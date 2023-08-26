package quanlyshopthoitrangj74.capnhat.capnhatnhacungcap;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import quanlyshopthoitrangj74.capnhat.capnhatsanpham.QuanLySanPham;

public class QuanLyNhaCungCap {
	static Scanner sc = new Scanner(System.in);

	private static LinkedList<NhaCungCap> list = new LinkedList<>();

	public static LinkedList<NhaCungCap> getList() {
		return list;
	}

	public static void setList(LinkedList<NhaCungCap> list) {
		QuanLyNhaCungCap.list = list;
	}

	public static int autoId = 101;

	public static void init() {
		list.add(new NhaCungCap(autoId++, "Viet Tien", "Ha Noi"));
		list.add(new NhaCungCap(autoId++, "An Phuoc", "Ha Noi"));
		list.add(new NhaCungCap(autoId++, "May 10", "Thanh pho Ho Chi Minh"));
	}

	public static void quanLyNhaCungCap() {
		do {
			System.out.println("\n\t\t\t=========CAP NHAT THONG TIN NHA CUNG CAP=========");
			System.out.println("Chon thong tin cap nhat");
			System.out.println("\t1. Xem danh sach nha cung cap");
			System.out.println("\t2. Them nha cung cap moi");
			System.out.println("\t3. Sua thong tin nha cung cap");
			System.out.println("\t4. Xoa thong tin nha cung cap");
			System.out.println("\t5. Sap xep danh sach nha cung cap");
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
		System.out.println("\t\t\t==========DANH SACH NHA CUNG CAP==========");
		System.out.printf("%10s %-35s %-55s%n", "ID", "NAME", "ADDRESS");
		for (NhaCungCap x : list) {
			x.display();
		}

	}

	private static void add() {
		System.out.println("\n\t\t\tTHEM MOI NHA CUNG CAP");
		System.out.printf("Nhap vao so luong nha cung cap muon them: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; ++i) {
			System.out.println("Nhap vao thong tin nha cung cap thu " + (i+1) + ": ");
			System.out.println("Nhap vao ten nha cung cap: ");
			String name = sc.nextLine();
			int index = findByName(name);
			if (name.trim().length() == 0) {
				System.out.println("Ten nha cung cap khong duoc de trong!");
				return;
			}
			if (index != -1) {
				System.out.println("Ten nha cung cap da ton tai trong danh sach");
			}
			System.out.print("Nhap vao dia chi nha cung cap: ");
			String address = sc.nextLine();
			list.add(new NhaCungCap(autoId++, name, address));
		}
		System.out.println("Them nha cung cap thanh cong!");
	}

	private static void update() {
		System.out.println("\n\t\t\tCHINH SUA THONG TIN NHA CUNG CAP");
		System.out.println("Nhap vao ID nha cung cap ban muon sua: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findByID(id);
		if (index == -1) {
			System.out.println("Nha cung cap khong co trong danh sach!");
		}
		System.out.print("Nhap vao ten moi cua nha cung cap: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("Ten nha cung cap khong duoc de trong!");
			return;
		}
		if (findByName(name) != -1) {
			System.out.println("Ten nha cung cap da ton tai trong danh sach");
		}
		list.get(index).setName(name);
		System.out.print("Nhap vao dia chi moi cua nha cung cap: ");
		String address = sc.nextLine();
		list.get(index).setAddress(address);
		System.out.println("Sua thong tin nha cung cap thanh cong!");
	}

	private static void remove() {
		System.out.println("\n\t\t\tXOA NHA CUNG CAP");
		System.out.println("Nhap vao ID nha cung cap ban muon xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = findByID(id);
		if (index == -1) {
			System.out.println("Nha cung cap khong co trong danh sach!");
		}
		if(QuanLySanPham.findByIdncc(id) != -1) {
			System.out.println("Khong the xoa nha cung cap da xuat hien o san pham!");
			return;
		}
		list.remove(index);
		System.out.println("Xoa nha cung cap thanh cong!");
	}

	private static void sort() {
		Collections.sort(list, new Comparator<NhaCungCap>() {

			@Override
			public int compare(NhaCungCap o1, NhaCungCap o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});
		System.out.println("Sap xep thanh cong!");
	}

	public static int findByID(int id) {
		for (int index = 0; index < list.size(); ++index) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}

	public static int findByName(String name) {
		for (int index = 0; index < list.size(); ++index) {
			if (list.get(index).getName().trim().equalsIgnoreCase(name.trim())) {
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
