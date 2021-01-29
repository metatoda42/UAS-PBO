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
	int controlvariable=0;
    Model model;
    View view;
    
    public Controller(View view, Model model){
        this.model = model;
        this.view = view;
        view.jbsave.setEnabled(false);
        view.jbedit.setEnabled(false);
        if (model.getBanyakData() != 0) {
            String dataMahasiswa[][] = model.read();
            view.tabel.setModel((new JTable(dataMahasiswa, view.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
        
        
        view.jbsave.addActionListener(new ActionListener() {//Tombol Simpan
            @Override
            public void actionPerformed(ActionEvent e) {
            	mastervariable=0;
            	
            	int ID = 0;
                String nama = view.getNama();
                String alamat = view.getAlamat();
                String jekel = view.getJekel();
                String tanggal = view.getTanggal();
                String notelp = view.getTelepon();
                if(controlvariable==2) {
                	model.tambah(nama, alamat, jekel, notelp, tanggal);
                }
                else {
                	ID=view.getID();
                	model.update(ID,nama, alamat, jekel, notelp, tanggal);
                }
                
                String dataMahasiswa[][] = model.read();
                view.tabel.setModel(new JTable(dataMahasiswa, view.namaKolom).getModel());
                view.disableall();
                view.jbsave.setEnabled(false);
            }
        });
        
        view.jbedit.addActionListener(new ActionListener() {//Tombol Update
            @Override
            public void actionPerformed(ActionEvent ae) {
            	view.enableall();
            	view.jtid.setEnabled(false);
            	view.jbsave.setEnabled(true);
            	controlvariable=1;
            }
        });
        
        view.jbcari.addActionListener(new ActionListener() {//Tombol Update
            @Override
            public void actionPerformed(ActionEvent ae) {
            	
            	String dataMahasiswa[][] = model.cari(view.getCari());
                view.tabel.setModel(new JTable(dataMahasiswa, view.namaKolom).getModel());
                view.disableall();
                view.jbsave.setEnabled(false);
            }
        });
        
        view.jbtambah.addActionListener(new ActionListener() {//Tombol Update
            @Override
            public void actionPerformed(ActionEvent ae) {
            	view.jtid.setText(null);
            	view.enableall();
            	view.jtid.setEnabled(false);
            	view.jbsave.setEnabled(true);
            	controlvariable=2;
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
                mastervariable=0;
                int baris = view.tabel.getSelectedRow();
                view.jbedit.setEnabled(true);
                String dataterpilih = (String) view.tabel.getValueAt(baris, 0);
                int data=Integer.parseInt(dataterpilih);
                view.jtid.setText(dataterpilih);
                
                System.out.println(dataterpilih);
                
                view.jbdelete.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent ae){
	                	if(mastervariable==0) {
	                		int input = JOptionPane.showConfirmDialog(null,"Apa anda ingin menghapus " + dataterpilih + "?", "Perhatian", JOptionPane.YES_NO_OPTION);
		                    if (input == 0) {
			                    model.delete(data);
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
                
