package interfaceTask;

public class Building {
	public static void main(String[] args) {
		Starbucks gangnam = new Starbucks();
		Starbucks jamsil = new Starbucks();
		Nike gangnamNike = new Nike();
		Nike jamsilNike = new Nike();

		gangnamNike.register(new FormAdapter() {
			
			@Override
			public String[] getMenu() {
				return new String[] {"�ĵ�Ƽ"};
			}
		});
		
		jamsilNike.register(new Form() {
			
			@Override
			public void sell(String menu) {
				String[] menus = getMenu();
				
				for (int i = 0; i < menus.length; i++) {
					if(menus[i].equals(menu)) {
						System.out.println(menu + " �Ǹ� �Ϸ�");
					}
				}
			}
			
			@Override
			public String[] getMenu() {
				return new String[] {"�ĵ�Ƽ", "����", "�縻", "�Ź�"};
			}
		});
		
		System.out.println();
		
//	      �޴��� �����ϸ� �Ǳ� ������ FormAdapter�� �ۼ��Ѵ�.
		jamsil.register(new FormAdapter() {

			@Override
			public String[] getMenu() {
				return new String[] { "��" };
			}
		});

//	      ��� ��ü�� �ۼ��ؾ� �ϱ� ������ Form�� �ۼ��Ѵ�.
		gangnam.register(new Form() {

			@Override
			public void sell(String menu) {
				String[] menus = getMenu();
				for (int i = 0; i < menus.length; i++) {
					if (menus[i].equals(menu)) {
						System.out.println(menu + " �Ǹ� �Ϸ�");
					}
				}
			}

			@Override
			public String[] getMenu() {
				return new String[] { "�Ƹ޸�ī��", "īǪġ��", "��������", "�̴Ͼ� �����" };
			}
		});
	}
}
















