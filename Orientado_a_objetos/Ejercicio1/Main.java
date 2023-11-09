import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creando un documento
        Documento documento = new Documento();

        // Creando una hoja
        Hoja hoja = new Hoja();

        // Creando algunas figuras geometricas
        Cuadro cuadro = new Cuadro(25);
        Circulo circulo = new Circulo(16);
        Elipse elipse = new Elipse(12, 6);

        // Agrupando las figuras geometricas
        Grupo grupo1 = new Grupo();
        grupo1.add(cuadro);
        grupo1.add(circulo);
        grupo1.add(elipse);

        // Creando dos textos
        Texto texto1 = new Texto("Hola Mundo", 4, 10);
        Texto texto2 = new Texto("Práctica Orientación a objetos", 8, 10);

        // Agrupando los textos
        Grupo grupo2 = new Grupo();
        grupo2.add(texto1);
        grupo2.add(texto2);

        // Creando más figuras geometricas
        Linea linea = new Linea(10);
        Rectangulo rectangulo = new Rectangulo(14, 6);

        // Agregando los objetos a la hoja
        hoja.add(grupo1);
        hoja.add(grupo2);
        hoja.add(linea);
        hoja.add(rectangulo);

        // Agregando la hoja al documento
        documento.add(hoja);

        // Ver los textos del grupo 2 accediendo desde el documento
        ArrayList<Objeto> obejtosDeHoja = documento.getHoja(0).getObjetos();
        for (Objeto objeto : obejtosDeHoja) {
            if (objeto instanceof Grupo) {
                ArrayList<Objeto> objetosDeGrupo = ((Grupo) objeto).getObjetos();
                for (Objeto objeto2 : objetosDeGrupo) {
                    if (objeto2 instanceof Texto) {
                        System.out.println(((Texto) objeto2).getTexto());
                    }
                }
            }
        }

    }
}