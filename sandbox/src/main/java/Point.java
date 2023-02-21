public class Point {

    private int x;
    private int y;

    public void Point (int x, int y ) {
        this.x=x;
        this.y=y;
    }
    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void setX(int x){
        this.x=x;
    }

    public void setY(int y){
        this.y=y;
    }

    public double distance (Point P2) {
        double res = ((P2.getX() - this.x) * (P2.getX() - this.x)) + ((P2.getY() - this.y) * (P2.getY() - this.y));
        return Math.sqrt(res);
    }
}