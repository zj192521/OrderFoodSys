import java.util.Scanner;

//�Ի����˶���ϵͳ
public class OrderFoodSys {

	public static void main(String[] args) {
		// ������������:��Ʒ
		String[] dishNames = {"���մ���","������˿","ʱ���߲�"};//�˵�����
		double[] prices = {38.0,20.0,10.0};//���
		int [] praiseNums = new int[3];
		//�����������壺����-������   ��Ʒ��Ϣ    �Ͳ�ʱ��   �Ͳ͵�ַ   �ܽ��   ����״̬
		
		String[] names = new String[4];
		String[] dishMsg = new String[4];
		int [] times = new int [4];
		String[] adresses = new String[4];
		double[] sumPrices = new double[4];
		int[] states = new int[4];//0�����Ѿ�Ԥ����1�����Ѿ����
		
		//��ʼ��������Ϣ
		names[0] ="����";
		dishMsg[0] = "���մ���2��";
		times[0] = 10;
		adresses[0] = "֪��·223��";
		sumPrices[0] =76;
		states[0] = 0;
		
		names[1] ="����";
		dishMsg[1] = "������˿1��";
		times[1] = 13;
		adresses[1] = "���·207��";
		sumPrices[1] =26;
		states[1] = 1;
		
		//���Ŀ�������̿��
		Scanner input = new Scanner(System.in);
		int num = -1;//�û�����0����ʱ�������֣�num=0ʱ�ظ���ʾ���˵�
		System.out.println("��ӭʹ�á��Ի����˶���ϵͳ��");
		
		//��¼�û��Ƿ��˳�ϵͳ��״̬
		boolean flag = false;
		do {
			System.out.println("**********************************");
			System.out.println("1����Ҫ����");
			System.out.println("2���鿴�ʹ�");
			System.out.println("3��ǩ�ն���");
			System.out.println("4��ɾ������");
			System.out.println("5����Ҫ����");
			System.out.println("6���˳�ϵͳ");
			System.out.println("**********************************");
			System.out.print("��ѡ��");
			
			int choose = input.nextInt();
			switch(choose) {
			case 1:
				System.out.println("************��Ҫ����************");
				//����ǰ�ж϶����Ƿ�δ��
				boolean  isAdd =false;
				for(int i=0;i<names.length;i++) {
					if(names[i]==null) {
						//����δ�������Զ���
						isAdd = true;
						//����
						System.out.print("�����붩����������");
						String name = input.next();
						//ѭ�������Ʒ��Ϣ
						System.out.println("���\t����\t����");
						for(int j=0;j<dishNames.length;j++) {
							String praise = (praiseNums[j]==0)?"":praiseNums[j]+"��";
							System.out.println((j+1)+"\t"+dishNames[j]+"\t"+prices[j]);
						}
						System.out.print("��������Ҫ��Ĳ�Ʒ��ţ�");
						int no = input.nextInt();
						while(no<1||no>dishNames.length) {
							System.out.println("����û�������Ʒ��������ѡ��");
							no = input.nextInt();
						}
						//��˷���
						System.out.print("����������Ҫ�ķ�����");
						int number = input.nextInt();
						//�Ͳ�ʱ������뼰�ж�
						System.out.print("�������Ͳ�ʱ�䣨�Ͳ�ʱ��ֻ����10-20֮������㣩����");
						int time = input.nextInt();
						while(time<10||time>20) {
							System.out.println("������������������10-20֮���������");
							time = input.nextInt();
						}
						//�Ͳ͵�ַ
						System.out.print("�������Ͳ͵�ַ��");
						String address = input.next();
						//��ӵ�������Ϣ
						System.out.println("���ͳɹ���");
						//��Ʒ��Ϣ����Ʒ����   ����
						String dishInfo = dishNames[no-1]+" "+number+"��";
						System.out.println("��������"+dishInfo);//�û�ѡ�Ĳ�Ʒ�±���������±�С1
						System.out.println("�Ͳ�ʱ�䣺"+time+"��");
						//�ͷ�    ���ͷ�     �ܼ�
						double dishPrice = prices[no-1]*number;
						double peiSong = (dishPrice>50)?0:6;
						double sumPrice = dishPrice +peiSong;
						System.out.println("�ͷѣ�"+dishPrice+"Ԫ�����ͷѣ�"+peiSong+"���ܼƣ�"+sumPrice+"Ԫ");
						
						//�Ѷ�����Ϣ��ӵ�������Ϣ�����붩����λ���ǹؼ���i
						names[i]= name;
						dishMsg[i]= dishInfo;
						times[i]= time;
						adresses[i]= address;
						sumPrices[i]= sumPrice;
						
						//���ͽ���������ѭ��
						break;
					}
				}
				if(!isAdd) {
					System.out.println("�Բ��𣬲ʹ�������");
				}
				break;
			case 2:
				System.out.println("************�鿴�ʹ�************");
				System.out.println("���\t������\t���Ͳ�Ʒ\t\t����ʱ��\t���͵�ַ\t\t�������\t����״̬");
				for(int i =0;i<names.length;i++) {
					if(names[i]!=null) {
						String time = times[i]+"��";
						String state = (states[i]==0)?"��Ԥ��":"�����";
						System.out.println((i+1)+"\t"+names[i]+"\t"+dishMsg[i]+"\t"+time+"\t"+adresses[i]+"\t"+sumPrices[i]+"\t"+state);
					}
					
				}
				break;
			case 3:
				System.out.println("************ǩ�ն���************");
				//ǩ��֮ǰ�ж϶����Ƿ����
				boolean isSign = false;
				System.out.print("��������Ҫǩ�յĶ�����ţ�");
				 int signNo = input.nextInt();
				for(int i=0;i<names.length;i++) {
					if(names[i]!=null && states[i]==0 && i==signNo-1) {
						//�ж����ţ����Ҷ���״̬Ϊ��Ԥ���������û�����Ķ���������ҵ�
						//��ǩ��
						isSign = true;
						states[i]=1;
						System.out.println("����ǩ�ճɹ���");
					}else if(names[i]!=null && states[i]==1 && i==signNo-1){
						isSign = true;
						System.out.println("��ѡ��Ķ����Ѿ����ǩ�գ������ٴ�ǩ�գ�");
					}
				}
				if(!isSign) {
					System.out.println("��ѡ�Ķ��������ڣ�");
				}
				
				break;
			case 4:
				System.out.println("************ɾ������************");
				//ɾ��֮ǰ���ж϶����Ƿ����
				//false-�����ڣ�����ɾ����true-���ڣ���Ԥ��״̬������ɾ�������ڣ����״̬��ɾ��
				boolean isDel = false;
				System.out.print("��������Ҫǩ�յĶ�����ţ�");
				 int delNo = input.nextInt();
				for(int i=0;i<names.length;i++) {
					if(names[i]!=null && states[i]==0 && i==delNo-1) {
						//�ж����ţ����Ҷ���״̬Ϊ��Ԥ���������û�����Ķ���������ҵ�
									isDel = true;
						//���Ҷ���״̬Ϊ��Ԥ��������ɾ��
									System.out.println("����δǩ�գ�����ɾ����");
					}else if(names[i]!=null && states[i]==1 && i==delNo-1){
						//�ж�����Ϣ�������û�����Ķ�����������ҵ�
						isDel = true;
						//���Ƕ���״̬Ϊ����ɣ���ɾ��
						//�ҵ�ɾ��������λ�� i����i�����Ԫ��������ǰ�ƶ������һ������Ԫ��Ҫ�ÿ�
						//ע�⣺�ƶ��Ĺ�����ʵ�ǰѺ�һ��Ԫ����ǰһ��Ԫ�ظ��ƵĹ���
						
						for(int j=i;j<names.length-1;j++) {
							names[j]=names[j+1];
							dishMsg[j]=dishMsg[j+1];
							times[j]=times[j+1];
							adresses[j] = adresses[j+1];
							sumPrices[j] = sumPrices[j+1];
							states[j] = states[j+1];
							
							//���һ��Ԫ��һ��Ҫ�ÿգ��ÿպ�Ϳ������µĶ�����
							names[names.length-1]=null;
							dishMsg[names.length-1]=null;
							times[names.length-1]=0;
							adresses[names.length-1] = null;
							sumPrices[names.length-1] = 0;
							states[names.length-1] = 0;
							
							
							
						}
						System.out.println("ɾ�������ɹ���");
						
					}
				}
				if(!isDel) {
					System.out.println("��ѡ�Ķ��������ڣ��޷�ɾ��");
				}
				
				break;
			case 5:
				System.out.println("************��Ҫ����************");
				//��ʾ��Ʒ��Ϣ
				System.out.println("���\t����\t\t����");
				for(int j=0;j<dishNames.length;j++) {
					String praise = (praiseNums[j]==0)?"":praiseNums[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t\t"+prices[j]+"\t"+praise);
				}
				
				//����
				System.out.print("��������Ҫ���޵Ĳ�Ʒ��ţ�");
				int praiseNo = input.nextInt();
				while(praiseNo<1||praiseNo>dishNames.length) {
					System.out.print("����û�������Ʒ���޷����ޣ�����������һ����Ʒ��ţ�");
					praiseNo =input.nextInt();
				}
				//�ؼ��㣺���ĸ�λ�õĲ�Ʒ������+1�����޲�Ʒ��λ��=praiseNo-1
				praiseNums[praiseNo-1]++;
				//������ɺ�ѭ�����
				System.out.println("���\t����\t\t����");
				for(int j=0;j<dishNames.length;j++) {
					String praise = (praiseNums[j]==0)?"":praiseNums[j]+"��";
					System.out.println((j+1)+"\t"+dishNames[j]+"\t\t"+prices[j]+"\t"+praise);
				}
				break;
			case 6:
				//�˳�ϵͳ
				flag = true;
				break;
			default:
				//�˳�ϵͳ
				flag = true;
				break;
			}
			if(!flag) {//!flag = flag ==false
				System.out.print("����0���أ�");
				num = input.nextInt();
			}else {
				break;
			}
			
		}while(num==0);
		System.out.println("ллʹ�ã���ӭ�´ι��٣�");
		
		}

}
