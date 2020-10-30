package simulation;

import java.io.*;
import java.util.*;

/**
 * 
 * @FileName BOJ1713.java
 * @author chlgpdus921
 * @date 2020. 10. 27.
 */
/* 후보 추천하기 */
public class BOJ1713 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int size = Integer.valueOf(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<>();
		//LinkedHashMap을 사용하면, Rule 3 - 두명이상일 경우, 오래된 사진 삭제 rule을 구현하지 않아도 된다.
		
		while (st.hasMoreElements()) {
			int key = Integer.valueOf(st.nextToken());
			if (hm.size() < n) {//처음에 들어오는 경우
				if (hm.containsKey(key)) {
					hm.replace(key, hm.get(key) + 1);
				} else
					hm.put(key, 1);
			} else if (hm.size() == n) {
				//비어있는 사진틀이 없는 경우
				if (hm.containsKey(key)) {
					//들어있는 사진일 경우 cnt+1
					hm.replace(key, hm.get(key) + 1);
				} else {
					List<Integer> keySetList = new ArrayList<>(hm.keySet());
					Collections.sort(keySetList, (o1, o2) -> (hm.get(o1).compareTo(hm.get(o2))));
					//그렇지 않을 경우, value순으로 정렬하고 제일 첫번째 key를 제거한다.
					int minKey = keySetList.get(0);
					hm.remove(minKey);
					hm.put(key, 1); //추천받은 새로운 key는 1로 들어간다.
				}
			}

		}

		StringBuilder sb = new StringBuilder();
		List<Integer> keySetList = new ArrayList<>(hm.keySet());
		Collections.sort(keySetList);
		for (int key : keySetList) {
			sb.append(key + " ");
		}
		System.out.println(sb);
	}

}
