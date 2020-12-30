package objects;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyCut implements MyObject2D {
    private MyPoint p1, p2;

    public MyCut(MyPoint p1, MyPoint p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public MyPoint getP1() {
        return p1;
    }

    public void setP1(MyPoint p1) {
        this.p1 = p1;
    }

    public MyPoint getP2() {
        return p2;
    }

    public void setP2(MyPoint p2) {
        this.p2 = p2;
    }

    @Override
    public List<MyPoint> getVertexes() {
        return Arrays.asList(p1, p2);
    }

    @Override
    public List<MyCut> getEdges() {
        return Collections.singletonList(this);
    }
}
