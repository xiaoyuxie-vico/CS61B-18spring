import java.lang.Math;

public class Planet {
    public double xxPos; //Its current x position
    public double yyPos; //Its current y position
    public double xxVel; //Its current velocity in the x direction
    public double yyVel; //Its current velocity in the y direction
    public double mass;  //Its mass
    public String imgFileName;

    /*
    First constructor
     */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /*
    Second constructor
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    /*
    Calculate the distance between two planets
     */
    public double calcDistance(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double dy = p.yyPos - this.yyPos;
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance;
    }

    /*
    The calcForceExertedBy method takes in a planet,
    and returns a double describing the force exerted
    on this planet by the given planet.
     */
    public double calcForceExertedBy(Planet p) {
        double G = 6.67e-11;
        double r = this.calcDistance(p);
        double F = G * this.mass * p.mass / (r * r);
        return F;
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        double Fx = F * dx / r;
        return Fx;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double r = this.calcDistance(p);
        double F = this.calcForceExertedBy(p);
        double Fy = F * dy / r;
        return Fy;
    }

    /*
    Calculate the net X force exerted by all planets
    in that array upon the current Planet
     */
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double netFx = 0;
        for (Planet p: allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            netFx += this.calcForceExertedByX(p);
        }
        return netFx;
    }

    /*
    Calculate the net Y force exerted by all planets
    in that array upon the current Planet
     */
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double netFy = 0;
        for (Planet p: allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            netFy += this.calcForceExertedByY(p);
        }
        return netFy;
    }

    public void update(double dt, double netFx, double netFy) {
        double ax = netFx / this.mass;
        double ay = netFy / this.mass;
        this.xxVel += dt * ax;
        this.yyVel += dt * ay;
        this.xxPos += dt * this.xxVel;
        this.yyPos += dt * this.yyVel;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/"+this.imgFileName);
    }
}