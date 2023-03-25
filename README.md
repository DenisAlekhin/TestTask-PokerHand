## Задание:
1. Реализовать класс для ранжирования покерных рук.
Класс должен содержать конструктор, который принимает на вход строку, содержащую пять карт: PokerHand hand = new PokerHand(&quot;KS 2H 5C JD TD&quot;);
Характеристики входной строки:
- В качестве разделителя используется пробел.
- Описание каждой карты состоит из двух символов:  
первый символ — это номинал карты. Допустимые значения: 2, 3, 4, 5, 6, 7, 8, 9, T(en), J(ack), Q(ueen), K(ing), A(ce);  
второй символ — масть.  
Допустимые значения: S(pades), H(earts), D(iamonds), C(lubs).  
2. Реализовать возможность сортировки рук по «силе» (рейтингу / рангу) от сильной к слабой: ArrayList&lt;PokerHand&gt; hands = new ArrayList&lt;PokerHand&gt;(); hands.add(new PokerHand(&quot;KS 2H 5C JD TD&quot;)); hands.add(new PokerHand(&quot;2C 3C AC 4C 5C&quot;)); Collections.sort(hands);  
Для упрощения считать, что туз в комбинациях стрит или стрит-флэш может быть только наивысшей картой.  
3. Класс PokerHand должен быть покрыт unit-тестами (определение комбинаций и сравнение комбинаций).  

##Пример результата работы:  
###До сортировки:  
pokerHands[0]: "2H 3H 4H 5H 6H"  
pokerHands[1]: "2D 2H 3S 3H QD"  
pokerHands[2]: "2D 2H 3S QH KD"  
pokerHands[3]: "2D 3H JS QH KD"  
pokerHands[4]: "7D 7H KH KS KD"  
pokerHands[5]: "QS QH QD KH AD"  
pokerHands[6]: "6H AH AC AD AS"  
pokerHands[7]: "2D 3H 4S 6H 7D"  
pokerHands[8]: "2D 2H 3S QH QD"  
pokerHands[9]: "2D 3H QS QH KD"  
pokerHands[10]: "2D 3H QS KH AD"  
pokerHands[11]: "2H 3H 4H 5H 9H"  
pokerHands[12]: "2D 6H QS QH QD"  

###После сортировки:  
pokerHands[0]: "2D 3H 4S 6H 7D"  
pokerHands[1]: "2D 3H JS QH KD"  
pokerHands[2]: "2D 3H QS KH AD"  
pokerHands[3]: "2D 2H 3S QH KD"  
pokerHands[4]: "2D 3H QS QH KD"  
pokerHands[5]: "2D 2H 3S 3H QD"  
pokerHands[6]: "2D 2H 3S QH QD"  
pokerHands[7]: "QS QH QD KH AD"  
pokerHands[8]: "2D 6H QS QH QD"  
pokerHands[9]: "2H 3H 4H 5H 9H"  
pokerHands[10]: "7D 7H KH KS KD"  
pokerHands[11]: "6H AH AC AD AS"  
pokerHands[12]: "2H 3H 4H 5H 6H"  
