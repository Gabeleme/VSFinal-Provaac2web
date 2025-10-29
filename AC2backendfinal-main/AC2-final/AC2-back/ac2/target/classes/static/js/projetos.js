// URL base da API (ajuste se necessário)
const API_URL = "/projeto";

// Função para carregar a lista de projetos e preencher a tabela
async function carregarProjetos() {
    try {
        const response = await fetch(API_URL);
        if (!response.ok) throw new Error("Erro ao buscar projetos");

        const projetos = await response.json();

        const tbody = document.getElementById("tbodyProjetos");
        tbody.innerHTML = "";

        projetos.forEach((p) => {
            const tr = document.createElement("tr");
            tr.innerHTML = `
        <td>${p.id}</td>
        <td>${p.descricao || p.nome || "—"}</td>
        <td>${p.descricao || "—"}</td>
        <td>${p.dataInicio || "—"}</td>
        <td>${p.dataFim || "—"}</td>
      `;
            tbody.appendChild(tr);
        });
    } catch (erro) {
        console.error("Erro ao carregar projetos:", erro);
        alert("Falha ao carregar a lista de projetos.");
    }
}

// Função para enviar o formulário de novo projeto
document.getElementById("formProjeto").addEventListener("submit", async (event) => {
    event.preventDefault();

    const projeto = {
        descricao: document.getElementById("descricao").value,
        dataInicio: document.getElementById("dataInicio").value,
        dataFim: document.getElementById("dataFim").value
    };

    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify(projeto)
        });

        if (response.ok) {
            alert("Projeto cadastrado com sucesso!");
            document.getElementById("formProjeto").reset();
            carregarProjetos();
        } else {
            alert("Erro ao cadastrar o projeto.");
        }
    } catch (erro) {
        console.error("Erro ao enviar formulário:", erro);
        alert("Falha ao conectar com o servidor.");
    }
});

// Carrega a lista automaticamente ao abrir a página
window.addEventListener("load", carregarProjetos);
