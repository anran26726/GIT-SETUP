import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
// import App from './client/components/App';
import Userlist from './client/components/userlist/userlist';
import * as serviceWorker from './serviceWorker';
import { Provider } from "react-redux";

// import store from "./client/redux/store";
import userListStore from "./client/redux/store/userlist";


ReactDOM.render(
  <Provider store={userListStore}>
    <Userlist />
  </Provider>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
