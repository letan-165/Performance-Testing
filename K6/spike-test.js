import http from "k6/http"; // Thêm dòng này để import thư viện http

export let options = {
  scenarios: {
    spike_test: {
      executor: "constant-arrival-rate",
      rate: 600, // Gửi 600 yêu cầu mỗi giây
      timeUnit: "1s", // Đo tần suất yêu cầu theo giây
      duration: "2s", // Tổng thời gian test là 2 giây
      preAllocatedVUs: 600, // Phân bổ 600 VUs
    },
  },
};

export default function () {
  http.get("http://localhost:8080/test/user/findAll");
}
