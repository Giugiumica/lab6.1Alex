package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            File file = new File("src/main/resources/angajati.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/angajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Angajat> angajati = mapper
                    .readValue(file, new TypeReference<List<Angajat>>() {
                    });
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Angajat> angajati = citire();

        System.out.println("\t    Meniul este :");
        System.out.println("1-Afisare angajati");
        System.out.println("2-Afisare angajati cu salariu mai mare de 2500");
        System.out.println("3-Crearea unei liste cu angajații din luna aprilie, a anului trecut, care au funcție de conducere");
        System.out.println("4-Afișarea angajaților care nu au funcție de conducere, în ordine descrescătoare a salariilor");
        System.out.println("5-Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților scrise cu majuscule");
        System.out.println("6-Extragerea din lista de angajați a unei liste de String-uri care conține numele angajaților scrise cu majuscule");
        System.out.println("7-Afișarea datelor primului angajat al firmei");
        System.out.println("8-Afișarea de statistici referitoare la salariul angajaților. Se va afișa salariul mediu, salariul minim şi salariul maxim");
        System.out.println("9-Afișarea unor mesaje care indică dacă printre angajați există cel puțin un “Ion”");
        System.out.println("10-Afișarea numărului de persoane care s-au angajat în vara anului precedent");
        Scanner meniu=new Scanner(System.in);

        do {
            System.out.println("\t Alegeti optiunea: ");
            int meniuVar= meniu.nextInt();

            switch (meniuVar) {
                case 1:angajati.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Angajatii cu salariu mai mare de 2500 sunt : ");
                    angajati.stream().filter(angajat -> angajat.getSalariu() > 2500).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println(angajati.stream()
                            .filter(angajat -> angajat.getDataAngaj().isAfter(LocalDate.of(2022, 4, 1)))
                            .filter(angajat -> angajat.getPost().contains("sef") || angajat.getPost().contains("director"))
                            .collect(Collectors.toList()));
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("\tAi introdus o varianta de pe landa meniu :))");
                    break;
            }
        }while (true);

    }
}

