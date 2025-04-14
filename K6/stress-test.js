import http from "k6/http"; // Thêm dòng này để import thư viện http
import { check } from "k6";

export let options = {
  scenarios: {
    stress_test: {
      executor: "ramping-vus", // Executor tăng dần VUs
      startVUs: 800, // Bắt đầu với 800 VUs
      stages: [
        { duration: "5s", target: 800 }, // Tăng lên 800 VUs trong 5 giây
        { duration: "5s", target: 1000 }, // Tăng lên 1000 VUs trong 5 giây
        { duration: "5s", target: 1200 }, // Tăng lên 1200 VUs trong 5 giây
        { duration: "5s", target: 1500 }, // Tăng lên 1500 VUs trong 5 giây
        { duration: "5s", target: 1800 }, // Tăng lên 1800 VUs trong 5 giây
      ],
    },
  },
};

export default function () {
  // Gửi yêu cầu HTTP
  let res = http.get("http://localhost:8080/test/user/findAll");

  // Kiểm tra điều kiện nếu cần
  check(res, {
    "is status 200": (r) => r.status === 200,
  });
}
