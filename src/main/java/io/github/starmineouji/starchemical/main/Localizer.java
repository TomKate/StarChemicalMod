package io.github.starmineouji.starchemical.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Locale;
import java.util.Properties;

import javax.net.ssl.HttpsURLConnection;

public class Localizer {
	private Properties props = new Properties();

	public Localizer() throws IOException {
		// TODO Auto-generated constructor stub
		Locale loc = Locale.getDefault();
		String locstr = (loc.getLanguage() + "_" + loc.getCountry()).toLowerCase();
		System.out.println(locstr);
		URL u = new URL(
				"https://raw.githubusercontent.com/starmineouji/StarChemicalMod/master/src/main/resources/assets/starchemical/lang/"
						+ (locstr == null || locstr.equals("_")? "ja_jp": locstr) + ".lang");
		HttpsURLConnection c = (HttpsURLConnection) u.openConnection();
		getProps().load(new InputStreamReader(c.getInputStream(),"UTF-8"));
	}

	public Localizer(URL url) throws IOException {
		URLConnection c =  url.openConnection();
		getProps().load(c.getInputStream());
	}

	public Localizer(File f) throws IOException {
		getProps().load(new InputStreamReader( new FileInputStream(f), "UTF-8"));
	}

	public String getMessage(String str) {
		String property = props.getProperty(str);
		return property;
	}
	public Properties getProps() {
		return props;
	}
}