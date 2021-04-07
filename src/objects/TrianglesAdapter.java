package objects;

public class TrianglesAdapter extends Adapter{
    private int[][] mTrianglesPosition = {
            {24, 0},
            {35, 0},
            {36, 0},
            {48, 0},
            {49, 0},
            {50, 0}
    };
    public TrianglesAdapter () {
        for (int i = 0; i < mTrianglesPosition.length; i++) {
            Triangle t = new Triangle(x(mTrianglesPosition[i][0]), y(mTrianglesPosition[i][1]));
            this.add("triangle", t.getIcon(), t.getPosition());
        }
    }
}
