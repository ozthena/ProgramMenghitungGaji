package com.gaji;

import java.util.Scanner;

abstract class Pembuka{
    public abstract void pembuka_program();
}

class Opening extends Pembuka{
    @Override
    public void pembuka_program(){
        System.out.println("================================");
        System.out.println("         Menghitung Gaji        ");
        System.out.println("================================");
    }
}

interface gaji{
    void rincian_gaji();
}

class penentu_gaji implements gaji{
    @Override
    public void rincian_gaji() {
        System.out.println("--------------------------------");
        System.out.println("   Rincian Gaji yang Diperoleh  ");
        System.out.println("--------------------------------");
    }

    public void hitung_gaji(int jam_kerja){
        int hasil, jam_lembur, gaji_lembur, gaji_pokok;
        int gaji_perjam = 15000;

        if(jam_kerja>0 && jam_kerja <= 24){
            if(jam_kerja > 8){
                jam_lembur = jam_kerja - 8;
                gaji_lembur = jam_lembur * gaji_perjam * 8;
                gaji_pokok = gaji_perjam * 8;
                hasil = gaji_pokok + gaji_lembur;
            }else{
                jam_lembur = 0;
                gaji_lembur = 0;
                gaji_pokok = gaji_perjam * jam_kerja;
                hasil = gaji_pokok + gaji_lembur;
            }
            rincian_gaji();
            System.out.println("Jam Lembur  : " + jam_lembur);
            System.out.println("Gaji Pokok  : " + gaji_pokok);
            System.out.println("Gaji Lembur : " + gaji_lembur);
            System.out.println("Total Gaji  : " + hasil);
        }else{
            System.out.println("Inputan Salah!");
        }
    }
}

class Pengguna{
    private int jam_kerja;
    Scanner input = new Scanner(System.in);

    public void setJam_kerja(){
        System.out.print("Masukkan Jam Kerja : ");
        this.jam_kerja = input.nextInt();
    }

    public int getJam_kerja(){
        return this.jam_kerja;
    }
}

public class Main{
    public static void main(String[] args){
        Opening opening = new Opening();
        opening.pembuka_program();

        Pengguna user = new Pengguna();
        user.setJam_kerja();

        penentu_gaji hitungGaji = new penentu_gaji();
        hitungGaji.hitung_gaji(user.getJam_kerja());
    }
}
