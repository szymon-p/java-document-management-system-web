function algBM() {
	
	//Funkcja ignoruje użycie klawiszy, kolejno CapsLock, Alt, Ctrl, Shift.
	var key = event.keyCode || event.charCode;
	if (key === 20 || key === 18 || key === 17 || key === 16); else {
		
		// Rozpoczęcie rejestracji czasu wykonania kodu w konsoli przeglądarki.
		console.time('algBM');
		
		// pattern - zawartość tekstowa inputa do filtrowania danych opartego o algorytm BM.
		// table - zawartość tabeli. - Lokalizowana po id w documents.html.
		// tr, td - odpowiednio wiersze i komórki tabeli.
		// tdString - zawartość tekstowa konkretnych komórek tabeli.
		// currPS - położenie prefikso-sufiksu bieżącego sufiksu.
		// i - położenie kolejnych elementów w tablicach.
		var pattern, table, tr, td, tdString, currPS, i;
		
		// Pobranie tekstu filtrowanej frazy oraz zamiana liter na duże.
		pattern = document.getElementById("inputAlgBM").value.toUpperCase();
		
		// Pobranie zawartości tabeli.
		table = document.getElementById("table");
		
		// Z pobranej tablicy wyszczególnienie wierszy tabeli.
		tr = table.tBodies[0].getElementsByTagName("tr");

		// Przejście po wierszach tabeli.
		for (var w = 0; w < tr.length; w++) {
			
			// Wyszczególnienie komórek tabeli z wierszy.
			td = tr[w].getElementsByTagName("td");
			
			// Ukrywanie wierszy tabeli. - Wiersze pasujące do filtra będą ponownie wyświetlane.
			tr[w].style.display = "none";
			
			// Kod wykonywany, jeśli istnieją komórki tabeli.
			if (td) {

				// Przejście po wszystkich komórkach tabeli.
				for (var k = 1; k < td.length; k++) {

					// Wyciągnięcie tekstu z komórki tabeli do zmiennej.
					tdString = td[k].textContent.toUpperCase();

					// Ilość znaków łańcucha tekstowego.
					var N = tdString.length;
					
					// Ilość znaków wzorca.
					var M = pattern.length;
					
					// Zawiera położenia znaków we wzorcu.
					var Last = [];
					
					// Przesunięcia okna wzorca dla pasujących sufiksów.
					var Next = [M + 1];
					
					// Inicjalizacja pomocniczej tablicy M + 1 elementowej do tablicy Next.
					var helpNext = [M + 1];

					// Obliczenie tablicy Last dla wzorca.
					// Wyznaczenie położenia ostatniego znaku we wzorcu.
					for (i = 0; i < M; i++) Last[pattern[i] - 1] = i;

					// Zerowanie elementów tablicy dla długości wzorca.
					for (i = 0; i <= M; i++) Next[i] = 0;
					
					// Ustawienie położenia startowego tablicy pomocniczej.
					i = M;
					
					// Ustawienie początkowego położenia prefikso-sufiksu sufiksu.
					currPS = M + 1;
					
					// Podanie wartości ostatniego elementu tablicy pomocniczej.
					helpNext[i] = currPS;

					// Pętla, która dodaje kolejne elementy do tablicy pomocniczej.
					while (i > 0) {
						
						// Pętla dotyczy aktualnego i istniejącego prefikso-sufiksu, którego nie można rozszerzyć w lewo.
						while ((currPS <= M) && (pattern[i - 1] != pattern[currPS - 1])) {
							
							// Warunek zapewniający zapis aktualnego i istniejącego prefikso-sufiksu, 
							// którego nie można rozszerzyć w lewo, do tablicy Next.
							if (Next[currPS] == 0) Next[currPS] = currPS - i;
							
							// Odnotowanie położenia prefikso-sufiksu względem tablicy pomocniczej. 
							currPS = helpNext[currPS];
						}
						
						// Przesunięcie się na kolejną pozycję w lewo i zapis położenia w tablicy pomocniczej.
						helpNext[--i] = --currPS;
					}

					// Przekazanie do zmiennej najdłuższego prefikso-sufiksu.
					currPS = helpNext[0];
					
					// Przejście po kolejnych elementach tablicy Next.
					for (i = 0; i <= M; i++) {
						
						// Umieszczenie położeń currPS prefikso-sufiksów w pustych położeniach tablicy Next.
						if (Next[i] == 0) Next[i] = currPS;
						
						// Przypadek kiedy prefikso-sufiks nie mieści się w sufiksie (i == currPS)
						if (i == currPS)
							
							// Przekazanie kolejnego prefikso-sufiksu.
							currPS = helpNext[currPS];
					}

					// Przesunięcie okna wzorca na początek łańcucha tesktowego.
					i = 0;
					
					//Kod, który wykonywany jest do momentu, aż okno wzorca wyjdzie poza filtrowany łańcuch znaków.
					while (i <= N - M) {
						
						// Ustawienie rozpoczęcia porównywania wzorca od jego końca.
						var j = M - 1;
						
						// Kod, który wykonywany jest w obrębie okna wzorca, do momentu, kiedy znak wzorca jest taki sam, jak znak w łańcuchu tekstowym.
						while ((j > -1) && (pattern[j] == tdString[i + j])) j--;

						// Kod, który jest wykonywany, gdy filtrowany wzorzec pasuje do okna wzorca. W przeciwnym przypadku wykonywany jest kod w instrukcji else.
						if (j == -1) {
							
							// Wyświetlenie rekordu w tabeli oraz przerwanie bieżącej iteracji pętli.
							tr[w].style.display = ""; break;
							
						// Wzorzec nie psuje do okna wzorca. - Następuje przesunięcie okna wzorca na kolejne położenie (maksymalnie o długość wzorca).	
						} else i += Math.max(Next[j + 1], j - Last[tdString[i + j] - 1]);
					}
				}
			}
		}
		
		// Zakończenie rejestracji czasu wykonania kodu.
		console.timeEnd('algBM');
		
		// Przekazanie do skryptu pagination.js danych, które powinny zostać wyświetlone w tabeli.
		settingOptions($('#table tr:gt(0)').filter(':visible'));
	}
}