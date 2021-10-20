function algKMP() {
	
	//Funkcja ignoruje użycie klawiszy, kolejno CapsLock, Alt, Ctrl, Shift.
	var key = event.keyCode || event.charCode;
	if (key === 20 || key === 18 || key === 17 || key === 16); else {
		
		// Rozpoczęcie rejestracji czasu wykonania kodu w konsoli przeglądarki.
		console.time('algKMP');
		
		// pattern - zawartość tekstowa inputa do filtrowania danych opartego o algorytm KMP.
		// table - zawartość tabeli. - Lokalizowana po id w documents.html.
		// tr, td - odpowiednio wiersze i komórki tabeli.
		// tdString - zawartość tekstowa konkretnych komórek tabeli.
		// lengthPS - długość prefikso-sufiksu.
		// i - położenie kolejnych elementów w tablicach.
		var pattern, table, tr, td, tdString, lengthPS, i;
		
		// Pobranie tekstu filtrowanej frazy oraz zamiana liter na duże.
		pattern = document.getElementById("inputAlgKMP").value.toUpperCase();
		
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
					
					// Tablica maksymalnych długości prefiko-sufiksów, prefiksów wzorca.
					var Next = [ M + 1 ];

					// Ustawienie długości prefikso-sufiksu oraz wartości początkowej tablicy Next.
					Next[0] = lengthPS = -1;
					
					// Pętla odpowiedzialna jest za wyznaczenie kolejnych długości prefikso-sufiksów dla prefiksów łańcucha tekstowego.
					for (i = 1; i <= M; i++) {
						
						// Poszukiwanie rozszerzalnego prefikso-sufiksu dla prefiksu wzorca.
						while ((lengthPS > -1) && (pattern[lengthPS] != pattern[i - 1])) lengthPS = Next[lengthPS];
						
						// Zwiększenie wartości długości prefikso-sufiksu.
						++lengthPS;
						
						// Warunek obsługuje przypadek, kiedy kolejny znak wzorca jest inny niż kolejny znak za prefikso-sufiksem.
						// Dodanie do tablicy długości prefikso-sufiksu.
						if ((i == M) || (pattern[i] != pattern[lengthPS])) Next[i] = lengthPS;
						
						// W przeciwnym przypadku w tablicy Next zostaje umieszczona skrócona długość prefikso-sufiksu.
						else Next[i] = Next[lengthPS];
					}

					// Ustawienie długości prefikso-sufiksu na zero.
					lengthPS = 0;
					
					// Porównywanie znaków łancucha tekstowego ze znakami wzorca.
					for (i = 0; i < N; i++) {
						
						// Porównywanie prefiksu wzorca, który jest rozszerzalny z prefiksem okna wzorca.
						// Jeśli taki zostanie znaleziony, to pętla kończy działanie.
						while ((lengthPS > -1) && (pattern[lengthPS] != tdString[i])) lengthPS = Next[lengthPS];
						
						// Jeśli zostanie znaleziony prefiks niepokrywający się w całości ze wzorcem, to działanie pętli jest kontynuowane.
						if (++lengthPS == M) {
							
							// Po znalezieniu prefiksu pokrywającego się w całości ze wzorcem, zostaje wyświetlony wiersz w tabeli.
							tr[w].style.display = ""; break;
						}
					}
				}
			}
		}
		
		// Zakończenie rejestracji czasu wykonania kodu.
		console.timeEnd('algKMP');
		
		// Przekazanie do skryptu pagination.js danych, które powinny zostać wyświetlone w tabeli.
		settingOptions($('#table tr:gt(0)').filter(':visible'));
	}
}