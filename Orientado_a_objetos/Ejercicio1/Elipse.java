/**
 * La clase Elipse representa un objeto elipse con propiedades como eje mayor, eje menor y área.
 */
public class Elipse extends Objeto {
    private int ejeMayor;
    private int ejeMenor;
    private int area;

    public Elipse(int ejeMayor, int ejeMenor) {
        this.ejeMayor = ejeMayor;
        this.ejeMenor = ejeMenor;
        this.area = (int) (Math.PI * ejeMayor * ejeMenor);
    }

    public int getEjeMayor() {
        return ejeMayor;
    }

    public int getEjeMenor() {
        return ejeMenor;
    }

    public int getArea() {
        return area;
    }

    public void setEjeMayor(int ejeMayor) {
        this.ejeMayor = ejeMayor;
    }

    public void setEjeMenor(int ejeMenor) {
        this.ejeMenor = ejeMenor;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
