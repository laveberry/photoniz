// src/main/frontend/src/App.js

import React, {useEffect, useState} from 'react';
import axios from 'axios';
import SearchHeader from "./components/Common/SearchHeader";
import Layout from "./components/Common/Layout";
import HomeContainer from "./components/Common/HomeContainer";
import '@fortawesome/fontawesome-free/js/all.js'


function App() {
  const [hello, setHello] = useState('')

  useEffect(() => {
    axios.get('/api/hello')
        .then(response => setHello(response.data))
        .catch(error => console.log(error))
  }, []);

  return (
      <Layout>
          <HomeContainer></HomeContainer>
        백엔드에서 가져온 데이터입니다 : {hello}
      </Layout>
  );
}

export default App;