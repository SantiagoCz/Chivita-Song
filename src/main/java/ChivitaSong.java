import java.util.*;

public class ChivitaSong {

    public static void main(String[] args) {

        List<String> animals = loadAnimals();

        Map<String, String> callMap = new HashMap<>();
        String current = "la chiva";
        Random random = new Random();
        int totalLinesPrinted = 0;

        // Línea inicial de la canción
        totalLinesPrinted++; // Contamos la línea inicial
        printLine(totalLinesPrinted, "Sal de ahí chivita chivita, sal de ahí de ese lugar");

        // Número de iteraciones (N)
        int N = 1;

        Set<String> calledAnimals = new HashSet<>(); // Para rastrear animales ya llamados

        for (int i = 0; i < N; i++) {
            // Seleccionar animal aleatorio que no haya sido llamado antes
            String next;
            do {
                next = animals.get(random.nextInt(animals.size()));
            } while (calledAnimals.contains(next));

            calledAnimals.add(next); // Añadir a la lista de llamados
            callMap.put(current, next);

            // Mostrar el animal que va a ser llamado
            totalLinesPrinted++;
            printLine(totalLinesPrinted, "Hay que llamar a " + next + " para que saque a " + current);

            // Actualizar la chiva actual
            current = next;

            // Crear lista de remoción
            List<String> remover = new ArrayList<>();
            String inspect = "la chiva";
            while (callMap.containsKey(inspect)) {
                String animalCalled = callMap.get(inspect);
                remover.add(animalCalled + " no quiere sacar a " + inspect);
                inspect = animalCalled;
            }

            // Imprimir la lista de remoción
            for (String line : remover) {
                totalLinesPrinted++; // Contamos cada línea de remoción
                printLine(totalLinesPrinted, line);
            }

            // Imprimir la última línea de cada iteración
            totalLinesPrinted++; // Línea final de iteración
            printLine(totalLinesPrinted, "La chiva no quiere salir de ahí. Sal de ahí chivita chivita, sal de ahí de ese lugar");
        }

        // Calcular el tiempo total de ejecución
        System.out.println("Considerando que cada línea lleva 1 milisegundo en ejecutarse, el tiempo de ejecución esperado es de : " + totalLinesPrinted + " ms");
    }

    // Método para imprimir la línea con el número correspondiente
    private static void printLine(int lineNumber, String text) {
        System.out.println(lineNumber + ". " + text);
    }

    // Método para cargar los 100 animales
    private static List<String> loadAnimals() {
        return Arrays.asList(
                "el lobo", "el toro", "el perro", "el gato", "el león", "el zorro ártico", "el quokka",
                "el tigre", "el oso", "el elefante", "el rinoceronte", "el mono", "el jaguar", "el alce",
                "el puma", "el cocodrilo", "el ciervo", "el hipopótamo", "el búho", "el wallaby",
                "la serpiente", "el águila", "el halcón", "el búfalo africano", "el flamenco", "el pingüino",
                "el canguro", "el delfín", "la ballena", "el rinoceronte blanco", "la tortuga", "el gorila",
                "el hámster", "el erizo", "el antílope", "el chivo", "el venado", "el ratón", "la ardilla",
                "el gato montés", "el pajarito", "el loro", "la rana", "el pato", "la foca", "el lince",
                "el perezoso", "el coyote", "el armadillo", "el búho real", "el ganso", "la avestruz",
                "el pez", "el tapiro", "el tiburón", "el colibrí", "la medusa", "la estrella de mar",
                "el cangrejo", "el pez payaso", "la anguila", "el pez espada", "el pez globo", "el dingo",
                "la mariposa", "el escorpión", "el tucán", "la araña", "el mosquito", "la abeja",
                "el suricata", "la avispa", "la luciérnaga", "la mantis religiosa", "el grillo",
                "el saltamontes", "el ciempiés", "la cucaracha", "la langosta", "el caracol",
                "el caracol de mar", "la mariposa monarca", "la polilla", "el escarabajo", "el milpiés",
                "la lombriz", "el pez ángel", "el pez loro", "el puma de montaña", "el manatí",
                "el pez linterna", "la morena", "el pez gato", "el pez cuchillo", "el delfín mular",
                "el manatí antillano", "el pez escorpión", "el pez globo", "el pez loro", "la gaviota",
                "el búho nival", "la foca leopardo", "el buitre", "el pez tigre", "el cernícalo",
                "el flamingo", "el goliat", "el chorlito", "la serpiente de cascabel", "el perezoso de tres dedos",
                "el puma de las pampas", "el dragón de Komodo", "el basilisco", "la anguila eléctrica",
                "el ciervo rojo", "el oso panda", "el venado cola blanca", "la ardilla voladora",
                "la paloma mensajera", "el loro arcoíris", "la ballena beluga", "el pelícano", "el ibis"
        );
    }

}
