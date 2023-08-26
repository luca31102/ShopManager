package quanlyshopthoitrangj74.capnhat.capnhatsanpham;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatchungloai.QuanLyChungLoai;
import quanlyshopthoitrangj74.capnhat.capnhatnhacungcap.QuanLyNhaCungCap;

public class QuanLySanPham {
	static Scanner sc = new Scanner(System.in);
	
	private static LinkedList<SanPham> list = new LinkedList<>();

	
	public static LinkedList<SanPham> getList() {
		return list;
	}

	public static void setList(LinkedList<SanPham> list) {
		QuanLySanPham.list = list;
	}

	public static int autoId = 1001;
	
	public static void init() {
		list.add(new SanPham(autoId++, 101, 11, "Quan dui hoa", 30, 150000));
		list.add(new SanPham(autoId++, 102, 12, "Quan dai den", 25, 250000));
		list.add(new SanPham(autoId++, 103, 13, "Ao coc polo", 40, 120000));
		list.add(new SanPham(autoId++, 101, 14, "Ao phong", 20, 90000));
		list.add(new SanPham(autoId++, 102, 15, "Ao kaki", 30, 200000));
	}

	public static void quanLySanPham() {
		do {
			System.out.println("\n\t\t\t=========CAP NHAT THONG TIN SAN PHAM=========");
			System.out.println("Chon thong tin cap nhat");
			System.out.println("\t1. Xem danh sach san pham");
			System.out.println("\t2. Them san pham moi");
			System.out.println("\t3. Sua thong tin san pham");
			System.out.println("\t4. Xoa san pham");
			System.out.println("\t5. Sap xep danh sach san pham");
			System.out.println("\t0. Quay lai");

			int chon;
			System.out.println("Nhap vao lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				display();
				break;
			case 2:
				add();
				break;
			case 3:
				update();
				break;
			case 4:
				remove();
				break;
			case 5:
				sort();
				break;
			case 0:
				return;
			default:
				System.out.println("Lua chon khong hop le!");
			}
		} while (true);
		
	}

	private static void display() {
		System.out.println("\t\t\t==========DANH SACH SAN PHAM==========");
		System.out.printf("%10s %-35s %-35s %-35s %-6s %-9s%n", "ID", "PROVIDER NAME",
				"TYPE NAME", "NAME", "AMOUNT", "PRICE");
		for(SanPham x : list) {
			x.display();
		}
		
	}

	private static void add() {
		System.out.println("\t\t\t==========THEM SAN PHAM==========");
		System.out.print("Nhap vao so san pham muon them: ");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++) {
			System.out.println("Nhap vao thong tin san pham thu " + (i+1) + ": ");
			
			System.out.print("Nhap vao id nha cung cap san pham: ");
			int idncc = Integer.parseInt(sc.nextLine());
			if(QuanLyNhaCungCap.findByID(idncc) == -1) {
				System.out.println("Nha cung cap khong ton tai!");
				return;
			}
			
			System.out.print("Nhap vao id chung loai: ");
			int idcl = Integer.parseInt(sc.nextLine());
			if(QuanLyChungLoai.findByID(idcl) == -1) {
				System.out.println("Chung loai khong ton tai!");
				return;
			}
			
			System.out.print("Nhap vao ten san pham: ");
			String name = sc.nextLine();
			if(name.length() == 0) {
				System.out.println("Ten khong duoc de trong!");
				return;
			}
			if(findByName(name) != -1) {
				System.out.println("San pham nay da xuat hien trong danh sach!");
				return;
			}
			
			System.out.print("Nhap vao so luong san pham: ");
			double amount = Double.parseDouble(sc.nextLine());
			if(amount < 0) {
				System.out.println("So luong khong duoc am!");
				return;
			}
			
			System.out.print("Nhap vao gia san pham: ");
			double price = Double.parseDouble(sc.nextLine());
			if(price < 0) {
				System.out.println("Gia khong duoc am!");
				return;
			}
			
			list.add(new SanPham(autoId++, idncc, idcl, name, amount, price));
		}
		System.out.println("Them san pham thanh cong!");
	}

	private static void update() {
		System.out.println("\t\t\t==========SUA THONG TIN SAN PHAM==========");
		System.out.print("Nhap vao id san pham ban muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findById(id);
		if(index == -1) {
			System.out.println("San pham khong co trong danh sach!");
		}
		do {
			System.out.println("Sua thong tin hang hoa " + id);
			System.out.println("Chon thong tin can sua");
			System.out.println("\t1. Sua ma nha cung cap");
			System.out.println("\t2. Sua ma chung loai");
			System.out.println("\t3. Sua ten san pham");
			System.out.println("\t4. Sua so luong san pham");
			System.out.println("\t5. Sua don gia san pham");
			System.out.println("\tQuay lai");
			
			System.out.println("Lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			
			switch(chon) {
			case 1: list.get(index).updateIdncc(); break;
			case 2: list.get(index).updateIdcl(); break;
			case 3: list.get(index).updateName(); break;
			case 4: list.get(index).updateAmount(); break;
			case 5: list.get(index).updatePrice(); break;
			case 0: return; 
			default: System.out.println("Lua chon khong hop le!"); break;
			}
		}while(true);
	}

	private static void remove() {
		System.out.println("\t\t\t==========XOA SAN PHAM==========");
		System.out.print("Nhap vao ID san pham ban muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findById(id);
		if(index == -1) {
			System.out.println("San pham khong ton tai!");
			return;
		}
		list.remove(index);
		System.out.println("Xoa san pham thanh cong!");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<SanPham>() {

			@Override
			public int compare(SanPham o1, SanPham o2) {
				// TODO Auto-generated method stub
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
			
		});
		System.out.println("Sap xep thanh cong!");
	}
	
	public static int findById(int id) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByName(String name) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByIdncc(int idncc) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getIdncc() == idncc) {
				return index;
			}
		}
		return -1;
	}
	
	public static int findByIdcl(int idcl) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getIdcl() == idcl) {
				return index;
			}
		}
		return -1;
	}
	
	public static SanPham getProductById(int id) {
		for(SanPham x : list) {
			if(x.getId() == id) {
				return x;
			}
		}
		return null;
	}

}
