package chessgame;

import chessgame.entities.Figure;

public class Vector3ifig {

        public int x;
        public int y;
        public Figure fig;

        public Vector3ifig(int x,int y,chessgame.entities.Figure fig)
        {
            this.fig=fig;
            this.x=x;
            this.y=y;
        }
}
