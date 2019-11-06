package vn.edu.tdmu.pmd.Movement;

public class Vector2D {
    private double x;
    private double y;

    public Vector2D() {
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vector2D other = (Vector2D) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }
    
    /* cộng */
    public Vector2D add(Vector2D v){
        this.x+=v.getX();
        this.y+=v.getY();
        return this;
    }
    
    public static Vector2D add(Vector2D v1,Vector2D v2) {
        Vector2D v3 = new Vector2D();
        v3.setX(v1.getX() + v2.getY());
        v3.setY(v1.getY() + v2.getY());
        return v3;
    }
    
    
    /* trừ */
    public Vector2D sub(Vector2D v) {
        this.x-= v.getX();
        this.y-= v.getY();
        return this;
    }
    
    public static Vector2D sub(Vector2D v1, Vector2D v2) {
        Vector2D v3 = new Vector2D();
        v3.setX(v1.getX() - v2.getY());
        v3.setY(v1.getY() - v2.getY());
        return v3;
    }
    
    /* nhân */
    public Vector2D mul(double c){
        this.x*=c;
        this.y*=c;
        return this;
    }
    
    public Vector2D mul(Vector2D v, double c) {
        Vector2D v3 = new Vector2D();
        v3.setX(v.getX() * c);
        v3.setY(v.getY() * c);
        return v3;
    }
    
    /* chia */
    public Vector2D div(double c) {
        this.x /= c;
        this.y /= c;
        return this;
    }
    
    public static Vector2D div(Vector2D v, double c) {
        Vector2D v3 = new Vector2D();
        v3.setX(v.getX()/c);
        v3.setY(v.getY()/c);
        return v3;
    }
    
    /* chuẩn hóa */
    public Vector2D normalize() {
        this.x=this.x/(Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2)));
        this.y=this.y/(Math.sqrt(Math.pow(this.x, 2)+Math.pow(this.y, 2)));
        return this;
    }
    
    public static Vector2D normalize(Vector2D v){
        Vector2D v3 = new Vector2D();
        v3.setX(v.getX()/(Math.sqrt(Math.pow(v.getX(), 2)+ Math.pow(v.getY(), 2))));
        v3.setY(v.getY()/(Math.sqrt(Math.pow(v.getX(), 2)+ Math.pow(v.getY(), 2))));
       return v3;
    }
    
    public double length(){
        return (Math.sqrt(Math.pow(this.x, 2)+(Math.pow(this.y, 2))));
    }

    @Override
    public String toString() {
        return "Vector2D{" + "x=" + x + ", y=" + y + '}';
    }
}
