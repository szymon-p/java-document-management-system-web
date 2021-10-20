function algKR() {
	
	//Funkcja ignoruje użycie klawiszy, kolejno CapsLock, Alt, Ctrl, Shift.
	var key = event.keyCode || event.charCode;
	if (key === 20 || key === 18 || key === 17 || key === 16); else {
		
		// Rozpoczęcie rejestracji czasu wykonania kodu w konsoli przeglądarki.
		console.time('algKR');
		
		// pattern - zawartość tekstowa inputa do filtrowania danych opartego o algorytm KR.
		// table - zawartość tabeli. - Lokalizowana po id w documents.html.
		// tr, td - odpowiednio wiersze i komórki tabeli.
		// tdString - zawartość tekstowa konkretnych komórek tabeli.
		// i - położenie kolejnych elementów w tablicach.
		// haszTdStrings - hasz łańcucha tekstowego.
		// haszPattern - hasz wzorca.
		var pattern, table, tr, td, tdString, i, haszTdStrings, haszPattern;

		// Pobranie tekstu filtrowanej frazy oraz zamiana liter na duże.
		pattern = document.getElementById("inputAlgKR").value.toUpperCase();
		
		// Pobranie zawartości tabeli.
		table = document.getElementById("table");
		
		// Z pobranej tablicy wyszczególnienie wierszy tabeli.
		tr = table.tBodies[0].getElementsByTagName("tr");

		// Funkcja haszująca.
		function hasz(string) {
			
			// Deklaracja zmiennej, która będzie przechowywać zahaszowany ciąg znaków.
			var resultHasz = 0;
			
			// Właściwa część funkcji haszującej. - Haszowanie ciągu znaków podanego w argumencie funkcji.
			for (var i = 0; i < M; i++) resultHasz = 3 * resultHasz + (string[i] - 65);
			
			// Zwrócenie zahaszowanego ciągu znaków.
			return resultHasz;
		}
		
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

					// Algorytm nie radzi sobie w przypadku, kiedy długość łańcucha wprowadzanego 
					// jest większa niż długość łańcucha w konkretnej komórce. W związku z czym, 
					// przyjęto, że ilość znaków w komórce tabeli, wynosi zawsze jej maksymalną pojemność, 
					// czyli 100 znaków.
					var N = 100;

					// Ilość znaków wzorca.
					var M = pattern.length;

					// Obliczenie haszu wzorca.
					haszPattern = hasz(pattern).toString();
					
					// Obliczenie haszu łańcucha tekstowego.
					haszTdStrings = hasz(tdString).toString();

					// Ustawienie położenia okna wzorca.
					i = 0;

					// Wykonywanie pętli dopóki nie zostanie przerwana.
					while (true) {

						// Porównanie równości haszy okna wzorca i wzorca 
						// oraz sprawdzenie czy w położeniu "i" został znaleziony wzorzec.
						if ((haszPattern == haszTdStrings) && (pattern == tdString.substr(i, M))) {

							// Wyświetlenie wiersza w tabeli oraz przerwanie pętli.
							tr[w].style.display = ""; break;
						}
						
						// Przesunięcie okna wzorca w prawo o jeden.
						i++;
						
						// Weryfikacja, czy łańcuch tekstowy skończył się. Jeśli tak, to następuje przerwanie pętli.
						if (i == N - M) break;
						
						// W przeciwnym przypadku pętla jest kontynuowana 
						// oraz wyznaczany jest hasz nowego okna na podstawie haszu poprzedniego okna.
						haszTdStrings = ((haszTdStrings - (tdString[i - 1] - 65) * 27) * 3 + tdString[i + M - 1] - 65).toString();
					}
				}
			}
		}
		
		// Zakończenie rejestracji czasu wykonania kodu.
		console.timeEnd('algKR');
		
		// Przekazanie do skryptu pagination.js danych, które powinny zostać wyświetlone w tabeli.
		settingOptions($('#table tr:gt(0)').filter(':visible'));
	}
}