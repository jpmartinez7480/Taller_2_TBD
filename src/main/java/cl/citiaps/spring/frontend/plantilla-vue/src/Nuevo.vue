<template>
  <div class="center">
    <h2>{{title}}</h2>
    <ul class="user-form">
      <form >
        Nombre:
        <input v-model="actor.firstName" type="text" class="form-control"><br><br>
        Apellido:
        <input v-model="actor.lastName" type="text" class="form-control"><br><br>
        <button type="submit" class="btn btn-primary" v-on:click="signUp">
          Enviar
        </button>
      </form>
    </ul>
  </div>
</template>
<script>
export default {
  data(){
    return{
      title:'Nuevo Actor',
      actor:
      {
        firstNamename:'',
        lastName:'',
        lastUpdate: 1139988873000
      }
    }
  },
  methods:
  {
    signUp:function()
    {
      if(this.actor.actor_name!='' && this.actor.actor_lastname!='')
      {
        this.$http.post('http://localhost:8081/sakila-spring-backend/actors', this.actor);
        console.log("entro");
      }
      else
        console.log("no entro");
    }
  }
}
</script>
