const revealTargets = document.querySelectorAll(".reveal");

const observer = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    if (entry.isIntersecting) {
      entry.target.classList.add("is-visible");
      observer.unobserve(entry.target);
    }
  });
}, { threshold: 0.16 });

revealTargets.forEach((target, index) => {
  target.style.setProperty("--delay", `${index * 70}ms`);
  observer.observe(target);
});

const footerYear = document.getElementById("footer-year");
if (footerYear) {
  footerYear.textContent = `Current public repo build - ${new Date().getFullYear()}`;
}
