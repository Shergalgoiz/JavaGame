package vn.edu.tdmu.pmd.Movement;

public class KinematicSeek {
    private Kinematic character;
    private Kinematic target;
    private double maxSpeed;

    public KinematicSeek() {
    }

    public KinematicSeek(Kinematic character, Kinematic target, double maxSpeed) {
        this.character = character;
        this.target = target;
        this.maxSpeed = maxSpeed;
    }

    public Kinematic getCharacter() {
        return character;
    }

    public void setCharacter(Kinematic character) {
        this.character = character;
    }

    public Kinematic getTarget() {
        return target;
    }

    public void setTarget(Kinematic target) {
        this.target = target;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
    
    public KinematicOutput getKinematicOutput(){
        KinematicOutput kinematicOutput = new KinematicOutput();
        kinematicOutput.setLinear(Vector2D.sub(this.target.getPosition(),
                this.character.getPosition()));
        kinematicOutput.getLinear().normalize();
        kinematicOutput.getLinear().mul(maxSpeed);
        character.setOrientation(Kinematic.getNewOrientation(
                this.getTarget().getOrientation(), 
                kinematicOutput.getLinear()));
        this.getCharacter().setRotation(0);
        return kinematicOutput;
    }
    
    public static void main(String[] args) {
        KinematicSeek kinematicSeek = new KinematicSeek();
        kinematicSeek.setCharacter(new Kinematic(new Vector2D(1, 1), 0, null, 0));
        kinematicSeek.setTarget(new Kinematic(new Vector2D(20, 15), 0, null, 0));
        kinematicSeek.setMaxSpeed(3);
        
        KinematicOutput kinematicOutput;
        for (int i = 0; i < 3; i++) {
            kinematicOutput = kinematicSeek.getKinematicOutput();
            kinematicSeek.getCharacter().update(kinematicOutput, 1);
            System.out.println(kinematicSeek.getCharacter());
        }
    }
}

