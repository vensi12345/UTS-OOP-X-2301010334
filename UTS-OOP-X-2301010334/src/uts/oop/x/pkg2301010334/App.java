/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts.oop.x.pkg2301010334;

import java.util.Scanner;

/**
 *
 * @author INSTIKI
 */
public class App {
    private static final Note[] notes = new Note[100];
    private static int noteCount = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("Menu:");
                System.out.println("1. Tambah Catatan");
                System.out.println("2. Tampilkan Catatan");
                System.out.println("3. Ubah Catatan");
                System.out.println("4. Hapus Catatan");
                System.out.println("5. Keluar");
                System.out.print("Pilih opsi: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Clear buffer
                
                switch (choice) {
                    case 1:
                        addNote(scanner);
                        break;
                    case 2:
                        displayNotes();
                        break;
                    case 3:
                        editNote(scanner);
                        break;
                    case 4:
                        deleteNote(scanner);
                        break;
                    case 5:
                        System.out.println("Keluar dari aplikasi.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                }
            } while (choice != 5);
        }
    }

    private static void addNote(Scanner scanner) {
        if (noteCount < notes.length) {
            System.out.print("Masukkan judul catatan: ");
            String title = scanner.nextLine();
            System.out.print("Masukkan isi catatan: ");
            String content = scanner.nextLine();
            notes[noteCount++] = new Note(title, content);
            System.out.println("Catatan berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas catatan penuh.");
        }
    }

    private static void displayNotes() {
        if (noteCount == 0) {
            System.out.println("Tidak ada catatan yang tersedia.");
            return;
        }
        for (int i = 0; i < noteCount; i++) {
            System.out.println((i + 1) + ". " + notes[i]);
        }
    }

    private static void editNote(Scanner scanner) {
        displayNotes();
        System.out.print("Pilih nomor catatan yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine(); // Clear buffer

        if (index >= 0 && index < noteCount) {
            System.out.print("Masukkan judul baru: ");
            String newTitle = scanner.nextLine();
            System.out.print("Masukkan isi baru: ");
            String newContent = scanner.nextLine();
            notes[index].setTitle(newTitle);
            notes[index].setContent(newContent);
            System.out.println("Catatan berhasil diubah.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }

    private static void deleteNote(Scanner scanner) {
        displayNotes();
        System.out.print("Pilih nomor catatan yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;

        if (index >= 0 && index < noteCount) {
            for (int i = index; i < noteCount - 1; i++) {
                notes[i] = notes[i + 1];
            }
            notes[--noteCount] = null; // Clear last note
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Nomor catatan tidak valid.");
        }
    }
}

