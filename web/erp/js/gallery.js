const container = document.getElementById('container');

fetch('/res/article.json')
    .then(response => response.json())
    .then(medias => {
        medias.forEach(media => {
            const div = document.createElement('div');
            let element;
            if (media.type === 'image') {
                element = document.createElement('img');
                element.src = '/res/media/img/galery/' + media.src;
            }
            element.addEventListener('click', () => {
                const modalContent = document.getElementById('modal-content');
                modalContent.innerHTML = '';  // Clear previous content
                if (media.type === 'image') {
                    const img = document.createElement('img');
                    img.src = element.src;
                    modalContent.appendChild(img);
                } else if (media.type === 'video') {
                    const iframe = document.createElement('iframe');
                    iframe.src = element.src;
                    iframe.allow = "autoplay; encrypted-media";
                    iframe.allowFullscreen = true;
                    modalContent.appendChild(iframe);
                }
                const title = document.createElement('h2');
                title.textContent = media.title;
                modalContent.appendChild(title);
                document.getElementById('modal-preview').showModal();
            });
            const title = document.createElement('p');
            title.textContent = media.title;
            div.classList.add(media.type);  // Add class for filtering
            div.appendChild(element);
            div.appendChild(title);
            container.appendChild(div);
        });
    })
    .catch(error => console.error(error));
