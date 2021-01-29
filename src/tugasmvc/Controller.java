/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasmvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author Acer
 */
//Pandu Dhaulagiri - 124190044 - PBO A

public class Controller {
	int mastervariable=0;
    Model model;
    View view;
    
    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
        
        if (model.getBanyakData() != 0) {
            String dataMahasiswa[][] = model.read();
            view.tabel.setModel((new JTable(dataMahasiswa, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }

        view.jbsave.addActionListener(new ActionListener() {//Tombol Simpan
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = view.getNama();
                String alamat = view.getAlamat();
                String jekel = view.getJekel();
                String tanggal = view.getTanggal();
                String notelp = view.getTelepon();
                model.tambah(nama, jekel, alamat, notelp, tanggal);

                String dataMahasiswa[][] = model.read();
                view.tabel.setModel(new JTable(dataMahasiswa, view.namaKolom).getModel());
            }
        });
        
        view.jbedit.addActionListener(new ActionListener() {//Tombol Update
            @Override
            public void actionPerformed(ActionEvent ae) {
            	int id = view.getID();
            	String nama = view.getNama();
                String alamat = view.getAlamat();
                String jekel = view.getJekel();
                String tanggal = view.getTanggal();
                String notelp = view.getTelepon();
                model.update(id, nama, jekel, alamat, notelp, tanggal);

                String data[][] = model.read();
                view.tabel.setModel(new JTable(data, view.namaKolom).getModel());
            }
        });
        
        view.jbreset.addActionListener(new ActionListener() {//Tombol Reset
            @Override
            public void actionPerformed(ActionEvent ae) {
                model.reset();
                String data[][] = model.read();
                view.tabel.setModel(new JTable(data, view.namaKolom).getModel());
            }
        });

        view.tabel.addMouseListener(new MouseAdapter() {//Handling Buat Table
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int baris = view.tabel.getSelectedRow();
                
                int dataterpilih = (int) view.tabel.getValueAt(baris, 0);
                
                System.out.println(dataterpilih);
                
                view.jbdelete.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent ae){
	                	if(mastervariable>0) {
	                		int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin menghapus " + dataterpilih + "?", "Perhatian", JOptionPane.YES_NO_OPTION);
		                    if (input == 0) {
			                    model.delete(dataterpilih);
			                    String dataMahasiswa[][] = model.read();
			                    view.tabel.setModel(new JTable(dataMahasiswa, view.namaKolom).getModel());
			                    mastervariable+=1;
		                    } else {
		                    JOptionPane.showMessageDialog(null, "Cancelled");
		                    }
	                	}
	                }
                });
            }
        });
    }
}
                
