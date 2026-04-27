package com.hotelapp.hotelbackend.config;

import com.hotelapp.hotelbackend.model.Reserva;
import com.hotelapp.hotelbackend.service.ReservaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Scanner;

@Component
public class CLI implements CommandLineRunner {

    private final ReservaService service;

    public CLI(ReservaService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== HOTEL APP CLI =====");
            System.out.println("1. Crear reserva");
            System.out.println("2. Listar reservas");
            System.out.println("3. Buscar reserva");
            System.out.println("4. Cancelar reserva");
            System.out.println("5. Eliminar reserva");
            System.out.println("6. Ver configuración (Singleton)");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    System.out.print("Usuario: ");
                    String usuario = sc.nextLine();

                    System.out.print("Hotel: ");
                    String hotel = sc.nextLine();

                    System.out.print("Fecha entrada (YYYY-MM-DD): ");
                    LocalDate entrada = LocalDate.parse(sc.nextLine());

                    System.out.print("Fecha salida (YYYY-MM-DD): ");
                    LocalDate salida = LocalDate.parse(sc.nextLine());

                    Reserva r = new Reserva(null, usuario, hotel, entrada, salida, "ACTIVA");
                    service.crearReserva(r);

                    System.out.println("✔ Reserva creada");
                    break;

                case 2:
                    service.listar().forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("ID: ");
                    Long id = sc.nextLong();
                    sc.nextLine();

                    Reserva encontrada = service.buscar(id);
                    System.out.println(encontrada);
                    break;

                case 4:
                    System.out.print("ID a cancelar: ");
                    Long idCancel = sc.nextLong();
                    sc.nextLine();

                    service.cancelar(idCancel);
                    System.out.println("✔ Cancelada");
                    break;

                case 5:
                    System.out.print("ID a eliminar: ");
                    Long idDel = sc.nextLong();
                    sc.nextLine();

                    service.eliminar(idDel);
                    System.out.println("✔ Eliminada");
                    break;

                case 6:
                    Configuracion config = Configuracion.getInstancia();
                    System.out.println("Sistema: " + config.getNombreSistema());
                    System.out.println("Versión: " + config.getVersion());
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción inválida");
            }

        } while (opcion != 0);
    }
}