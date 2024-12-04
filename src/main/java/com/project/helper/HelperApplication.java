package com.project.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class HelperApplication {
	public static void main(String[] args)
	{
		SpringApplication.run(HelperApplication.class, args);
	}
}

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")class MedicineController {
	private static final Map<String, List<String>> medicines = new HashMap<>() {{
		put("두통", List.of("타이레놀", "게보린", "이지엔6"));
		put("소화불량", List.of("베아제", "훼스탈", "겔포스"));
		put("근육통", List.of("마이프로펜", "파스", "근육이완제"));
		put("감기", List.of("판콜에이", "콜대원", "화이투벤"));
	}};

	private static final Map<String, String> medicineDetails = new HashMap<>() {{
		put("타이레놀", "타이레놀은 두통에 효과가 있는 일반 의약품입니다.");
		put("게보린", "게보린은 빠른 두통 완화에 효과적입니다.");
		put("이지엔6", "이지엔6는 두통과 생리통 완화에 도움을 줍니다.");
		put("베아제", "베아제는 소화불량에 효과가 있는 소화제입니다.");
		put("훼스탈", "훼스탈은 소화를 도와주는 약품입니다.");
		put("겔포스", "겔포스는 속쓰림과 소화불량 완화에 도움을 줍니다.");
		put("마이프로펜", "마이프로펜은 근육통 완화에 효과적인 진통제입니다.");
		put("파스", "파스는 근육통 완화에 사용되는 외용 약품입니다.");
		put("근육이완제", "근육이완제는 근육통 및 긴장 완화에 도움을 줍니다.");
		put("판콜에이", "판콜에이는 감기 증상 완화에 도움을 주는 약품입니다.");
		put("콜대원", "콜대원은 감기와 기침 증상 완화에 효과적입니다.");
		put("화이투벤", "화이투벤은 감기 증상 완화에 도움이 되는 약품입니다.");
	}};


	@GetMapping("/medicines/{symptom}")
	public List<String> getMedicines(@PathVariable String symptom) {
		return medicines.getOrDefault(symptom, List.of());
	}

	@GetMapping("/medicine-detail/{name}")
	public Map<String, String> getMedicineDetail(@PathVariable String name) {
		String detail = medicineDetails.getOrDefault(name, "정보 없음");
		return Map.of("name", name, "detail", detail);
	}
}
