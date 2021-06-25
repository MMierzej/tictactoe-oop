# tictactoe-po

### Konsolowa implementacja klasycznej gry *Kółko i krzyżyk*.

#### Autor: Marcin Mierzejewski
#### Język: Java

## Opis projektu

Jest to konsolowa implementacja w języku Java klasycznej gry *Kółko i krzyżyk*. Zasady tej gry są znane niemal każdemu na całym świecie. Oprócz standardowego trybu gry *gracz vs. gracz*, dostępne są również do wyboru trzy poziomy trudności gry z komputerem: łatwy, średni i trudny.

#### Łatwy

Komputer nie jest zbyt przebiegły - każdy ruch wykonuje pseudolosowo.

#### Średni

Komputer nie daje się ograć tak łatwo - generalnie wykonuje ruchy losowo, natomiast, jeśli ma szansę bezpośrednio zwyciężyć, wykona ruch wygrywający. Podobnie, jeśli jest zagrożony bezpośrednią przegraną - obroni się.

#### Trudny

Komputer korzysta z algorytmu *minimax*, który pozwala mu w każdej partii na wygraną lub w najgorszym przypadku remis.
