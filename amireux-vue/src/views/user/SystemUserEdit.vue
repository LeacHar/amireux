<template>
  <a-modal
    title="编辑用户"
    :visible="visible"
    width="900px"
    :confirm-loading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel">
    <a-row>
      <a-form-model
        :model="form"
        ref="form"
        :label-col="labelCol"
        :rules="rules"
        :wrapper-col="wrapperCol"
      >
        <a-col span="12">
          <a-form-model-item label="用户名" prop="username">
            <a-input v-model="form.username" placeholder="请输入用户名" />
          </a-form-model-item>
        </a-col>
        <a-col span="12">
          <a-form-model-item label="密码" prop="password">
            <a-input type="password" v-model="form.password" placeholder="请输入密码" />
          </a-form-model-item>
        </a-col>
        <a-col span="12">
          <a-form-model-item label="确认密码" prop="confirmPassword">
            <a-input type="password" v-model="form.confirmPassword" placeholder="再次输入密码" />
          </a-form-model-item>
        </a-col>
        <a-col span="12">
          <a-form-model-item label="手机" prop="phone">
            <a-input v-model="form.phone" placeholder="请输入手机" />
          </a-form-model-item>
        </a-col>
        <a-col span="12">
          <a-form-model-item label="邮箱" prop="email">
            <a-input v-model="form.email" placeholder="请输入邮箱" />
          </a-form-model-item>
        </a-col>
        <a-col span="12">
          <a-form-model-item label="状态" prop="enable">
            <a-radio-group v-model="form.enable">
              <a-radio :value="true">
                启用
              </a-radio>
              <a-radio :value="false">
                停用
              </a-radio>
            </a-radio-group>
          </a-form-model-item>
        </a-col>
      </a-form-model>
    </a-row>
  </a-modal>
</template>

<script>
import { adduser, detail } from '@/api/system/user/SystemUser'

export default {
  name: 'SystemUserEdit',
  data () {
    return {
      visible: false,
      confirmLoading: false,
      form: {
        enable: true
      },
      labelCol: { span: 5, offset: 1 },
      wrapperCol: { span: 16 },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    preData (id) {
      detail({ 'id': id }).then(resp => {
        this.form = resp.data
        this.visible = true
        this.confirmLoading = false
      })
    },
    handleOk () {
      this.confirmLoading = true
      this.$refs.form.validate(valid => {
        if (!valid) {
          return false
        }
        adduser(this.form).then(resp => {
          if (resp.code === 2000) {
            this.visible = false
            this.$emit('success')
          }
        }).finally(() => {
          this.confirmLoading = false
        })
      })
    },
    handleCancel () {
      this.visible = false
      this.confirmLoading = false
    }
  }
}
</script>

<style scoped>

</style>
