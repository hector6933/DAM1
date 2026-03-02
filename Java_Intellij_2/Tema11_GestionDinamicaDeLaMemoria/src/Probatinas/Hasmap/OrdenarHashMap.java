package Probatinas.Hasmap;

import java.util.*;

public class OrdenarHashMap {
    public static void main(String[] args) {
        // 1. Crear el HashMap desordenado
        Map<String, Integer> mapa = new HashMap<>();
        mapa.put("Manzanas", 50);
        mapa.put("Naranjas", 20);
        mapa.put("Plátanos", 80);
        mapa.put("Uvas", 30);

        // 2. Convertir a lista y ordenar por valor
        List<Map.Entry<String, Integer>> lista = new ArrayList<>(mapa.entrySet());

        // Ordenar Ascendente (para Descendente: o2.getValue().compareTo(o1.getValue()))
        lista.sort(Map.Entry.comparingByValue());

        // 3. Insertar en un LinkedHashMap para mantener el orden
        Map<String, Integer> mapaOrdenado = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : lista) {
            mapaOrdenado.put(entry.getKey(), entry.getValue());
        }

        // Mostrar resultado
        System.out.println(mapaOrdenado);
    }
}
