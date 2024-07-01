document.addEventListener('DOMContentLoaded', function () {
    const sidebar = document.getElementById('sidebar');
    const sidebarCollapse = document.getElementById('sidebarCollapse');

    sidebarCollapse.addEventListener('click', function () {
        if (sidebar) {
            sidebar.classList.toggle('active');
            sidebar.classList.toggle('collapsed');
        }
    });
});
