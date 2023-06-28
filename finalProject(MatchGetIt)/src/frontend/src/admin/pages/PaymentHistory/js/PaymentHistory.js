function setDateRange(days) {
    var startDate = new Date();
    var endDate = new Date();
    endDate.setDate(endDate.getDate() - days);

    var startDateInput = document.getElementById("checkStartDate");
    var endDateInput = document.getElementById("checkEndDate");

    startDateInput.value = formatDate(startDate);
    endDateInput.value = formatDate(endDate);
  }

  function formatDate(date) {
    var year = date.getFullYear();
    var month = ("0" + (date.getMonth() + 1)).slice(-2);
    var day = ("0" + date.getDate()).slice(-2);
    return year + "-" + month + "-" + day;
  }