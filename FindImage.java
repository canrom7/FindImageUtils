
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//javac FindImage.java   ����
//java FindImage		 ִ��
public class FindImage {
	private static String outPath;
	private static int count = 0;
	private static int rename = 1;
	public static void main(String[] args) {
		
		// ���ҵ��ļ��е�ַ
		File inFile = new File("D:\\360data\\��Ҫ����\\����\\Weather");
		// ������ļ��е�ַ
		outPath = "D:\\360data\\��Ҫ����\\����\\weat\\";

		copyFind(inFile);
		System.out.println("���Ƹ����ļ���" + count + "����");

	}

	public static void copyFind(File f) {

		if (f != null) {// �ж��ļ��Ƿ�Ϊ��
			if (f.isDirectory()) {// �ж��Ƿ����ļ���
				System.out.println("-�ļ�����--��" + f.getAbsolutePath());
				File[] root = f.listFiles();// ��ȡĿ¼�µ��ļ���
				for (File file : root) {
					copyFind(file);
					count++;
				}
			} else {
				System.out.println("�ļ�����" + f.getName());
				if (f.getName().endsWith("jpg") || f.getName().endsWith("png")
						|| f.getName().endsWith("jpeg")
						|| f.getName().endsWith("ico")) {
					createFile(f.getAbsolutePath(), f.getName());
				}
			}
		}
	}

	public static void createFile(String path, String fileName) {

		File in = new File(path);
		File out = new File(outPath + "mgp" + fileName);

		try {
			FileInputStream input = new FileInputStream(in);
			FileOutputStream output = new FileOutputStream(out);
			int len;
			byte[] by = new byte[102400];
			System.out.println("-��ʼ���ƣ�" + fileName);
			int i = 0;
			while ((len = input.read(by, 0, by.length)) != -1) {
				i++;
				System.out.println(i);
				output.write(by, 0, len);
				output.flush();
			}
			System.out.println("---------���ƽ�����" + fileName + "\n\n\n");
			input.close();
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
