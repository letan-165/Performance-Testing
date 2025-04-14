import http from 'k6/http';  // Thêm dòng này để import thư viện http

export let options = {
    scenarios: {
      load_test: {
        executor: 'constant-arrival-rate',
        rate: 500,    // 500 yêu cầu mỗi giây
        timeUnit: '1s', // Đo tần suất yêu cầu theo giây
        duration: '5s', // Tổng thời gian test là 5 giây
        preAllocatedVUs: 500, // Phân bổ 500 VUs ban đầu
      },
    },
  };
  
  export default function () {
    http.get('http://localhost:8080/test/user/findAll');
  };
  