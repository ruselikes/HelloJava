package lab3;

import lab3.Recievers_Handlers.IEv;

public class Source {
    // Класс источника события
        IEv iEv;
        public Source(IEv iEv) {this.iEv= iEv;} // Конструктор
        public void genEv() {iEv.Handler();} // Генерировать событие



}
