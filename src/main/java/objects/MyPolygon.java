package objects;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyPolygon implements MyObject2D {
    private List<MyPoint> vertexes;
    private Color color = Color.BLACK;

    public MyPolygon(List<MyPoint> vertexes) {
        this.vertexes = vertexes;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public List<MyPoint> getVertexes() {
        return vertexes;
    }

    @Override
    public List<MyCut> getEdges() {
        List<MyCut> cuts = new ArrayList<>();
        for (int i = 0; i < vertexes.size() - 1; i++) {
            cuts.add(new MyCut(vertexes.get(i), vertexes.get(i + 1)));
        }
        cuts.add(new MyCut(vertexes.get(vertexes.size() - 1), vertexes.get(0)));
        return cuts;
    }

    public void setVertexes(List<MyPoint> vertexes) {
        this.vertexes = vertexes;
    }

    public double square() {
        int n = vertexes.size();
        int[][] matrix = new int[n][2];
        int i = 0;
        for (MyPoint p : vertexes) {
            matrix[i][0] = p.getX();
            matrix[i][1] = p.getY();
            i++;
        }
        double sum1 = 0;
        double sum2 = 0;
        for (i = 0; i < n -1; i++) {
            sum1 += matrix[i][0] * matrix[i + 1][1];
            sum2 += matrix[i + 1][0] * matrix[i][1];
        }
        sum1 += matrix[n - 1][0] * matrix[0][1];
        sum2 += matrix[0][0] * matrix[n - 1][1];
        return 0.5 * Math.abs(sum1 - sum2);
    }
}
