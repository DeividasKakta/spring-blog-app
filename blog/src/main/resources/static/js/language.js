$(document).ready(function() {
    // Set language on change
    $("#locales").on("change", () => {
        let selectedOption = $('#locales').val();
        if (selectedOption !== ''){
            window.location.replace('?lang=' + selectedOption);
        }
    });
});