public class NBody {
   public static double readRadius(String fileName) {
      In in = new In(fileName);
      int NumPlanet = in.readInt();
      double radius = in.readDouble();
      return radius;
   }

   public static Planet[] readPlanets(String fileName) {
      In in = new In(fileName);

      int numPlanet = in.readInt();
      double radius = in.readDouble();

      Planet[] allPlanets = new Planet[numPlanet];

      for (int i=0; i < numPlanet; i++) {
         double xxP = in.readDouble();
         double yyP = in.readDouble();
         double xxV = in.readDouble();
         double yyV = in.readDouble();
         double mass = in.readDouble();
         String imgPath = in.readString();
         Planet p = new Planet(xxP, yyP, xxV, yyV, mass, imgPath);
         allPlanets[i] = p;
      }
      return allPlanets;
   }

   public static void main (String[] args) {
      double T = Double.parseDouble(args[0]);
      double dt = Double.parseDouble(args[1]);
      String filename = args[2];

      Planet[] allPlanets = readPlanets(filename);
      int numPlanet = allPlanets.length;
      double radius = NBody.readRadius(filename);

      // Draw a background
      StdDraw.setScale(-1*radius, radius);
      StdDraw.picture(0, 0, "images/starfield.jpg");
      StdDraw.show();

      for (Planet p : allPlanets) {
         p.draw();
      }

      // Animation
      for (int i =0; i < T; i += dt){
         double[] xForces = new double[numPlanet];
         double[] yForces = new double[numPlanet];

         for (int j = 0 ; j < numPlanet; j++){
            xForces[j] = allPlanets[j].calcNetForceExertedByX(allPlanets);
            yForces[j] = allPlanets[j].calcNetForceExertedByY(allPlanets);
         }

         StdDraw.picture(0, 0, "images/starfield.jpg");

         for (int j = 0 ; j < numPlanet; j++){
            allPlanets[j].update(dt, xForces[j], yForces[j]);
            allPlanets[j].draw();
         }
         StdDraw.show(10);
      }

      StdOut.printf("%d\n", numPlanet);
      StdOut.printf("%.2e\n", radius);
      for (int i = 0; i < numPlanet; i++) {
         StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                 allPlanets[i].xxPos, allPlanets[i].yyPos, allPlanets[i].xxVel,
                 allPlanets[i].yyVel, allPlanets[i].mass, allPlanets[i].imgFileName);
      }
   }

}