package Composite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
//public class Test1 {
//	public static void main(String[] args) {
//
//		MenuItem open = new MenuItem("Open");
//		MenuItem close = new MenuItem("Close");
//		MenuItem exit = new MenuItem("Exit");
//
//		// 메뉴에 메뉴아이템을 추가합니다.
//		Menu file = new Menu("FILE");
//		file.add(open);
//		file.add(close);
//		file.add(exit);
//		
//		Menu edit = new Menu("EDIT");
//		edit.add(new MenuItem("Copy"));
//		edit.add(new MenuItem("Cut"));
//		edit.add(new MenuItem("Paste"));
//		
//		Menu help = new Menu("HELP");
//		help.add(new MenuItem("About"));
//		help.add(new MenuItem("Search"));
//		help.add(new MenuItem("Tip"));
//		
//		// 각 메뉴를 메뉴 바에 붙입니다.
//		Menu bar = new Menu("BAR");
//		bar.add(file);
//		bar.add(edit);
//		bar.add(help);
//		
//		
//
//		
//		
//
//		// 메뉴가 클릭되었다고 가정합니다.
//		file.perform();
//
//		// [FILE]
//		// 1. Open
//		// 2. Close
//		// 3. Exit
//		// -----------
//		// select: 1
//		// Open이 선택됨!
//		// 이러한 메뉴 시스템을 구현해 보세요 :D
//	}
//}
//
//// 메뉴는 메뉴아이템을 포함합니다.
//class MenuItem {
//	// 메뉴 아이템도 자신의 이름이 있습니다.
//	private String title;
//	public MenuItem(String title) { this.title = title; }
//
//	public String getTitle() { return title; }
//
//	// 메뉴 아이템은 자신이 클릭되었을 때의 이벤트를 처리해야 하므로 이를 수행하기 위한
//	// 핸들러를 가지고 있습니다.
//	public void perform() {
//		System.out.printf("%s가 선택됨!\n", title);
//	}
//}
//
//class Menu {
//	// 메뉴는 자신의 고유한 이름이 있습니다.
//	private String title;
//	private List<MenuItem> list = new ArrayList<>();
//
//	public String getTitle() { return title; }
//
//	public Menu(String title) { this.title = title; }
//
//	public void add(MenuItem item) { list.add(item); }
//
//	// 메뉴는 자신이 클릭되었을 때, 자신이 가지고 있는 항목들을 출력합니다.
//	public void perform() {
//		while(true) {
//			Menu.clear();
//			System.out.printf("[%s]\n", title);	// [FILE]
//			for (int i = 0; i < list.size(); i++)
//				System.out.printf("%d. %s\n", i+1, list.get(i).getTitle());
//			System.out.println("---------------");
//			System.out.print("input(0. up): ");
//
//			int num = Menu.getInt();
//			
//			// 만약 0을 입력하면 루프를 빠져나와 종료합니다.
//			if (num == 0) break;
//			
//			// 번호를 잘못 입력했을 경우, 다시 입력을 받는다.
//			if (num < 1 || num > list.size()) continue;
//			
//			// 선택된 항목에 대하여 일을 수행한다.
//			list.get(num-1).perform();
//			Menu.pause();
//		}
//
//	}
//
//	// 아래의 메서드는 출력 코드를 간단히 하게 위해 사용한 유틸리티 메서드입니다.
//	// -------------------------------------------------
//	// 이클립스의 console 창은 표준 출력 결과를 리다이렉션하여 표시하므로
//	// 출력 창을 지울 수 없습니다. 이를 위해 clear 메서드를 추가합니다.
//	public static void clear() {
//		for(int i = 0; i < 30; i++)
//			System.out.println();
//	}
//
//	// 표준 입력을 처리하기 위해 아래의 메서드를 추가합니다.
//	public static int getInt() {
//		return new Scanner(System.in).nextInt();
//	}
//
//	// 화면을 일시 정지하기 위해 아래의 메서드를 추가합니다.
//	public static void pause() {
//		try { System.in.read();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//}

public class Test1 {
	public static void main(String[] args) {
		Menu file = new Menu("FILE");
		file.add(new MenuItem("Open"));
		file.add(new MenuItem("Close"));
		file.add(new MenuItem("Exit"));
		
		Menu edit = new Menu("EDIT");
		edit.add(new MenuItem("Copy"));
		edit.add(new MenuItem("Cut"));
		edit.add(new MenuItem("Paste"));
		
		Menu help = new Menu("HELP");
		help.add(new MenuItem("About"));
		help.add(new MenuItem("Search"));
		help.add(new MenuItem("Tip"));
		
		Menu bar = new Menu("BAR");
		bar.add(file);
		bar.add(edit);
		bar.add(help);
		
		bar.perform();
	}
}

// 메뉴는 자기 자신과 메뉴 아이템을 포함할 수 있어야 하므로
// 메뉴와 메뉴 아이템을 하나의 타입으로 처리하기 위해 상속을 사용합니다.
// 이러한 디자인 패턴을 컴포지트 패턴이라고 합니다.
abstract class BaseMenu {	// class AbstractMenu
	private String title;
	public BaseMenu(String title) { this.title = title; }
	public String getTitle() { return title; }
	
	// 자식의 공통의 기능은 반드시 부모가 제공해야 합니다.
	// LSP(Liskov Substitution Principle): 리스코프의 치환 원식
	// 객체 지향의 5대 원칙 중 하나입니다.
	// 이 때, 자식 클래스가 아래의 메서드를 반드시 구현하도록 추상 메서드로 선언합니다.
	public abstract void perform();
}
// 이제 메뉴와 메뉴 아이템은 BaseMenu를 상속하기로 약속합니다.
class MenuItem extends BaseMenu {
	public MenuItem(String title) { super(title); }
	public void perform() {
		System.out.printf("%s가 선택됨!\n", getTitle());
	}
}
class Menu extends BaseMenu {
	// 메뉴와 메뉴 아이템을 저장하기 위해 부모 클래스를 사용합니다.
	private List<BaseMenu> list = new ArrayList<>();
	public Menu(String title) { super(title); }

	public void add(BaseMenu item) { list.add(item); }

	public void perform() {
		while(true) {
			Menu.clear();
			System.out.printf("[%s]\n", getTitle());	// [FILE]
			for (int i = 0; i < list.size(); i++)
				System.out.printf("%d. %s\n", i+1, list.get(i).getTitle());
			System.out.println("---------------");
			System.out.print("input(0. up): ");

			int num = Menu.getInt();
			
			// 만약 0을 입력하면 루프를 빠져나와 종료합니다.
			if (num == 0) break;
			
			// 번호를 잘못 입력했을 경우, 다시 입력을 받는다.
			if (num < 1 || num > list.size()) continue;
			
			// 선택된 항목에 대하여 일을 수행한다.
			list.get(num-1).perform();
			Menu.pause();
		}

	}

	// 아래의 메서드는 출력 코드를 간단히 하게 위해 사용한 유틸리티 메서드입니다.
	// -------------------------------------------------
	// 이클립스의 console 창은 표준 출력 결과를 리다이렉션하여 표시하므로
	// 출력 창을 지울 수 없습니다. 이를 위해 clear 메서드를 추가합니다.
	public static void clear() {
		for(int i = 0; i < 30; i++)
			System.out.println();
	}

	// 표준 입력을 처리하기 위해 아래의 메서드를 추가합니다.
	public static int getInt() {
		return new Scanner(System.in).nextInt();
	}

	// 화면을 일시 정지하기 위해 아래의 메서드를 추가합니다.
	public static void pause() {
		try { System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}




package Composite;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		// 디렉터리와 파일을 저장하는 구조를 설계하고 디렉터리 안의 파일에 대하여
		// 총 크기를 구하는 프로그램을 구현해 보세요 :D
		Directory root = new Directory("\\");
		root.add(new File("a.txt", 10));

		Directory dir1 = new Directory("A");
		dir1.add(new File("a.txt", 10));
		dir1.add(new File("b.txt", 20));
		dir1.add(new File("c.txt", 30));

		Directory dir2 = new Directory("B");
		dir2.add(new File("a.txt", 10));
		dir2.add(new File("b.txt", 10));

		root.add(dir1);
		root.add(dir2);

		System.out.println(dir1.getSize());	// 60
		System.out.println(dir2.getSize()); // 20
		System.out.println(root.getSize());	// 90
	}
}

abstract class Item {
	public String name;
	public Item(String name) { this.name = name; }
	public abstract int getSize();
}
class File extends Item {
	private int size;
	public File(String name, int size) {
		super(name);
		this.size = size;
	}
	@Override
	public int getSize() { return size; }
}
class Directory extends Item {
	private List<Item> list = new ArrayList<>();
	public Directory(String name) { super(name); }
	public void add(Item item) { list.add(item); }
	@Override
	public int getSize() {
		int size = 0;
		for (Item item : list)
			size += item.getSize();
		return size;
	}
}
