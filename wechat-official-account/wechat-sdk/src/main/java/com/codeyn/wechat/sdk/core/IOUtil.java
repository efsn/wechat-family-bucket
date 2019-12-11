/**
 * Copyright (c) 2016 Arthur Chan 陈 (codeyn@163.com).
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO
 * THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 */
package com.codeyn.wechat.sdk.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codeyn.wechat.sdk.core.model.WxBase;

public class IOUtil {

	private static Logger logger = LoggerFactory.getLogger(IOUtil.class);

	public static String readUrl(String url, String charsetName) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream(), charsetName))) {
			StringBuilder sb = new StringBuilder();
			String s;
			while ((s = br.readLine()) != null)
				sb.append(s);
			return sb.toString();
		} catch (Exception e) {
			logger.error("readUrl error:" + e.getMessage(), e);
			return null;
		}
	}

	public static String readFile(String path) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),
				WxBase.ENCODING))) {
			StringBuilder sb = new StringBuilder();
			String s;
			while ((s = br.readLine()) != null)
				sb.append(s);
			return sb.toString();
		} catch (Exception e) {
			logger.error("readUrl error:" + e.getMessage(), e);
			return null;
		}
	}

	public static String readFile(String path, String charsetName) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),
				charsetName))) {
			StringBuilder sb = new StringBuilder();
			String s;
			while ((s = br.readLine()) != null)
				sb.append(s);
			return sb.toString();
		} catch (Exception e) {
			logger.error("readUrl error:" + e.getMessage(), e);
			return null;
		}
	}

	public static String readFile(File f) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), WxBase.ENCODING))) {
			StringBuilder sb = new StringBuilder();
			String s;
			while ((s = br.readLine()) != null)
				sb.append(s);
			return sb.toString();
		} catch (Exception e) {
			logger.error("readUrl error:" + e.getMessage(), e);
			return null;
		}
	}

	public static String readFile(File f, String charsetName) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f), charsetName))) {
			StringBuilder sb = new StringBuilder();
			String s;
			while ((s = br.readLine()) != null)
				sb.append(s);
			return sb.toString();
		} catch (Exception e) {
			logger.error("readUrl error:" + e.getMessage(), e);
			return null;
		}
	}

	public static boolean writeFile(String path, String content, boolean append) {
		return writeFile(new File(path), content, append);
	}

	public static boolean writeFile(File f, String content, boolean append) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(f, append))) {
			bw.write(content);
			return true;
		} catch (Exception e) {
			logger.error("readUrl error:" + e.getMessage(), e);
			return false;
		}
	}
}
