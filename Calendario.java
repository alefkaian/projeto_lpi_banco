import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

public class Calendario {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    private Calendar c = Calendar.getInstance();
    private Map<Date, ArrayList<Tarefa>> calendario = new HashMap<>();

    public Calendario() {
    }

    public void atualizarCalendario(ArrayList<Tarefa> listaTarefas) {
        Map<Date, ArrayList<Tarefa>> calendarioAtualizado = new HashMap<>();
        for (Tarefa tarefa : listaTarefas) {
            {
                try {
                    Date prazo = sdf.parse(tarefa.getDataPrazo());
                    calendarioAtualizado.putIfAbsent(prazo, new ArrayList<>());
                    calendarioAtualizado.get(prazo).add(tarefa);
                } catch (ParseException j) {
                    System.out.println("Erro ao converter a data: " + j.getMessage());
                }
            }
        }
        this.calendario = calendarioAtualizado;
    }


    public void exibirCalendario(ArrayList<Tarefa> listaTarefas) {
        atualizarCalendario(listaTarefas);
        System.out.println("\nCalendário");
        TreeMap<Date, ArrayList<Tarefa>> calendarioOrdenado = new TreeMap<>(calendario);
        for (Date data : calendarioOrdenado.keySet()) {
            System.out.println("\nPrazo: " + sdf.format(data));
            for (Tarefa tarefa : calendarioOrdenado.get(data)) {
                System.out.println(tarefa.getIdT() + "- " + tarefa.getTitulo());
            }
        }
    }

    public static String calcularNovaData(int qtdDias) {
        Calendar cAuxiliar = Calendar.getInstance();
        cAuxiliar.add(Calendar.DAY_OF_MONTH, qtdDias);
        return sdf.format(cAuxiliar.getTime());
    }
}