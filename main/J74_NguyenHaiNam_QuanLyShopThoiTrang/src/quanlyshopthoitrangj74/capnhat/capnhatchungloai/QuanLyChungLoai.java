package quanlyshopthoitrangj74.capnhat.capnhatchungloai;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatsanpham.QuanLySanPham;

public class QuanLyChungLoai {
	
	static Scanner sc = new Scanner(System.in);
	
	private static LinkedList<ChungLoai> list = new LinkedList<>();
	
	
	public static LinkedList<ChungLoai> getList() {
		return list;
	}


	public static void setList(LinkedList<ChungLoai> list) {
		QuanLyChungLoai.list = list;
	}
	
	public static int autoId = 11;
	
	public static void init() {
		list.add(new ChungLoai(autoId++, "Quan dui", "Mac vao mua dong"));
		list.add(new ChungLoai(autoId++, "Quan dai", "Mac vao mua he"));
		list.add(new ChungLoai(autoId++, "Ao coc", "Mac vao mua dong"));
		list.add(new ChungLoai(autoId++, "Ao dai", "Mac vao mua he"));
		list.add(new ChungLoai(autoId++, "Ao so mi", "Mac khi di ngu"));
	}

	public static void quanLyChungLoai() {
		do {
			System.out.println("\n=========CAP NHAT THONG TIN CHUNG LOAI=========");
			System.out.println("Chon thong tin cap chung loai");
			System.out.println("\t1. Hien thi danh sach chung loai");
			System.out.println("\t2. Them chung loai hang moi");
			System.out.println("\t3. Sua thong tin chung loai hang");
			System.out.println("\t4. Xoa thong tin chung loai hang");
			System.out.println("\t5. Sap xep danh sach chung loai hang");
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
		}while(true);
		
		
	}


	private static void display() {
		System.out.println("\n\t\t\t==========HIEN THI DANH SACH CHUNG LOAI==========");
		System.out.printf("%10s %-30s %-55s%n", "ID", "NAME", "DESCRIPTION");
		for(ChungLoai x : list) {
			x.display();
		}
	}


	private static void add() {
		System.out.println("\n\t\t\t==========THEM CHUNG LOAI==========");
		System.out.print("Nhap vao so luong chung loai ban muon them: ");
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; ++i) {
			System.out.println("Nhap vao thong tin chung loai thu " + (i+1) + ": ");
			System.out.print("Nhap vao ten chung loai ban muon them: ");
			String name = sc.nextLine();
			int index = findByName(name);
			if(name.trim().length() == 0) {
				System.out.println("Ten khong duoc de trong!");
				return;
			}
			if(index != -1) {
				System.out.println("Chung loai nay da co trong danh sach!");
				return;
			}
			System.out.print("Nhap vao mo ta: ");
			String description = sc.nextLine();
			list.add(new ChungLoai(autoId++, name, description));
		}
		System.out.println("Them chung loai thanh cong!");
	}


	private static void update() {
		System.out.println("\n\t\t\t==========CHINH SUA THONG TIN CHUNG LOAI==========");
		System.out.print("Nhap vao ID chung loai ban muon chinh sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findByID(id);
		if(index == -1) {
			System.out.println("Chung loai khong co trong danh sach!");
		}
		System.out.print("Nhap vao ten chung loai moi: ");
		String name = sc.nextLine();
		if(name.trim().length() == 0 ) {
			System.out.println("Ten khong duoc de trong!");
			return;
		}
		if(findByName(name) != -1) {
			System.out.println("Ten chung loai da co trong danh sach!");
			return;
		}
		list.get(index).setName(name);
		System.out.print("Nhap vao mo ta moi: ");
		String description = sc.nextLine();
		System.out.println("Chinh sua thong tin chung loai thanh cong!");
	}


	private static void remove() {
		System.out.println("\n\t\t\t==========XOA CHUNG LOAI==========");
		System.out.print("Nhap vao ID chung loai muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findByID(id);
		if(index == -1) {
			System.out.println("Chung loai khong co trong danh sach!");
			return;
		}
		if(QuanLySanPham.findByIdcl(id) != -1) {
			System.out.println("Khong the xoa chung loai da co trong san pham!");
			return;
		}
		list.remove(index);
		System.out.println("Xoa chung loai thanh cong!");
	}


	private static void sort() {
		Collections.sort(list, new Comparator<ChungLoai>() {

			@Override
			public int compare(ChungLoai o1, ChungLoai o2) {
				// TODO Auto-generated method stub
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
			
		});
		
	}
	
	public static int findByID(int id) {
		for(int index = 0; index < list.size(); ++index) {
			if(list.get(index).getId() == id) {
				return id;
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
	
	public static String getNameByID(int id) {
		for (int index = 0; index < list.size(); ++index) {
			if (list.get(index).getId() == id) {
				return list.get(index).getName();
			}
		}
		return null;
	}
}
