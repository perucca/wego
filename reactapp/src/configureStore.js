import { createStore, applyMiddleware } from 'redux'
import { createLogger } from 'redux-logger' 
import thunk from 'redux-thunk' 

import rootReducer from './reducers/rootReducer' 

const middlewares = applyMiddleware(thunk, createLogger())

export default function configureStore(preloadedState = {}) { 
  const store = createStore(rootReducer, preloadedState, middlewares)

  return store
}