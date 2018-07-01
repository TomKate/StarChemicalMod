package io.github.starmineouji.starchemical.lib;

import java.util.HashMap;
import java.util.Map;

public class Lambdas {
public static<K,V> Map<K,V> toMap(LambdaToMap<K, V> lambda){
	Map<K, V> map = new HashMap<>();
	lambda.lambda(map);
	return map;
}
}
