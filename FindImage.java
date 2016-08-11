
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//javac FindImage.java   编译
//java FindImage		 执行
public class FindImage {
	private static String outPath;
	private static int count = 0;
	private static int rename = 1;
	public static void main(String[] args) {
		
		// 查找的文件夹地址
		File inFile = new File("D:\\360data\\重要数据\\桌面\\Weather");
		// 输出的文件夹地址
		outPath = "D:\\360data\\重要数据\\桌面\\weat\\";

		copyFind(inFile);
		System.out.println("共计复制文件：" + count + "个！");

	}

	public static void copyFind(File f) {

		if (f != null) {// 判断文件是否为空
			if (f.isDirectory()) {// 判断是否是文件夹
				System.out.println("-文件夹名--：" + f.getAbsolutePath());
				File[] root = f.listFiles();// 获取目录下的文件名
				for (File file : root) {
					copyFind(file);
					count++;
				}
			} else {
				System.out.println("文件名：" + f.getName());
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
			System.out.println("-开始复制：" + fileName);
			int i = 0;
			while ((len = input.read(by, 0, by.length)) != -1) {
				i++;
				System.out.println(i);
				output.write(by, 0, len);
				output.flush();
			}
			System.out.println("---------复制结束：" + fileName + "\n\n\n");
			input.close();
			output.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
