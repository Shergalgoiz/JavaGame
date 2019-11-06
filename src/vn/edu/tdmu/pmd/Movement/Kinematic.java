package vn.edu.tdmu.pmd.Movement;

public class Kinematic {
    private Vector2D position;
    private double orientation;
    private Vector2D velocity;
    private double rotation;

    public Kinematic(Vector2D position, double orientation, Vector2D velocity, double rotation) {
        this.position = position;
        this.orientation = orientation;
        this.velocity = velocity;
        this.rotation = rotation;
    }    
   
    public Kinematic() {
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public double getOrientation() {
        return orientation;
    }

    public void setOrientation(double orientation) {
        this.orientation = orientation;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public double getRotation() {
        return rotation;
    }

    public void setRotation(double rotation) {
        this.rotation = rotation;
    }

    public void update(KinematicOutput kinematicOutput, double time) {
        this.velocity = kinematicOutput.getLinear();
        this.rotation = kinematicOutput.getAngular();
        this.position.add(this.velocity.mul(time));
        this.orientation += this.rotation * time;
    }

        public static double getNewOrientation(double currentOrientation, Vector2D velocity) {
        if (velocity.length() > 0) {
            return Math.atan2(-velocity.getX(), velocity.getY());
        }
        return currentOrientation;
    }
    public String toString() {
        return "Kinematic{" + "position=" + position + ", orientation=" + orientation + ", velocity=" + velocity + ", rotation=" + rotation + '}';
    }
}
